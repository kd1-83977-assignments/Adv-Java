package jspapp;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean 
{
	
	
	private int candidateId;
	
	private int count;
	private User user;
	//private int status;
	
	public VoteBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void voting()
	{
		
		try(CandidateDao cad =new CandidateDaoImpl(); 	UserDao user1=new UserDaoImpl())
		{
			if(user.getStatus()== 0)
			{
			count=cad.incrementVote(candidateId);
			if(count == 1)
			{
			user1.updateStatus(user.getId(),true);
			}
			}
			else {
				count=5;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}
