package src.com.secretd.web.dao;

import java.util.List;

import src.com.secretd.web.entity.Disease;

public interface DiseaseDao {
	 /*List<Disease> getList(int page, String title);

	 int getCount();*/

	// Disease get(String classCode);

	List<Disease> getList(int page, String title, String category);

	int getCount(int page, String title, String category);

}
