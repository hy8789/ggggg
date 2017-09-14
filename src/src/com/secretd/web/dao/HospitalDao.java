package src.com.secretd.web.dao;

import java.util.List;

import src.com.secretd.web.entity.Hospital;

public interface HospitalDao {
	List<Hospital> getList(int page, String title, String category, String address);

	int getCount(int page, String title, String category, String address);

}
