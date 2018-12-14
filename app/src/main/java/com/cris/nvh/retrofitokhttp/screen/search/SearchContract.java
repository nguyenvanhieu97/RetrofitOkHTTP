package com.cris.nvh.retrofitokhttp.screen.search;

import com.cris.nvh.retrofitokhttp.model.GithubUser;

public class SearchContract {
	interface View {
		void onLoadDataSuccessful(GithubUser githubUser);

		void onLoadDataFailed(String message);
	}

	interface Presenter {
		void getData(String input);
	}
}
