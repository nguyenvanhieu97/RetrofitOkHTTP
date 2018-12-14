package com.cris.nvh.retrofitokhttp;

import com.cris.nvh.retrofitokhttp.model.GithubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nvh
 * Contact: toiyeuthethao1997@gmail.com
 */

public interface GitHubClient {
	String PATH = "/search/users";
	String PARAMETER_QUERY = "q";
	@GET(PATH)
	Call<GithubUser> githubUser(
		@Query(PARAMETER_QUERY) String value
	);
}
