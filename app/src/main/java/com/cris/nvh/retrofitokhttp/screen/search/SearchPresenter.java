package com.cris.nvh.retrofitokhttp.screen.search;

import com.cris.nvh.retrofitokhttp.GitHubClient;
import com.cris.nvh.retrofitokhttp.model.GithubUser;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchPresenter implements SearchContract.Presenter {
	private static final String LOAD_DATA_FAILED = "Load data failed";
	private static final String BASE_URL = "https://api.github.com/";
	private SearchContract.View mView;

	public SearchPresenter(SearchContract.View view) {
		mView = view;
	}

	@Override
	public void getData(String url) {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		Retrofit.Builder builder = new Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create());
		Retrofit retrofit = builder.client(httpClient.build()).build();
		GitHubClient client = retrofit.create(GitHubClient.class);
		Call<GithubUser> call = client.githubUser(url);
		call.enqueue(new Callback<GithubUser>() {
			@Override
			public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
				mView.onLoadDataSuccessful(response.body());
			}

			@Override
			public void onFailure(Call<GithubUser> call, Throwable t) {
				mView.onLoadDataFailed(LOAD_DATA_FAILED);
			}
		});
	}
}
