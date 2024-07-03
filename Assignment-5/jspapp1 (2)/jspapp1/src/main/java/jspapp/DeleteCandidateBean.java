package jspapp;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean 
{
	private int id;
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public DeleteCandidateBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void DeleteCand()
	{
		try(CandidateDao cad =new CandidateDaoImpl())
		{
			count=cad.deleteById(id);
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
