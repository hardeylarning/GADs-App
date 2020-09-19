package com.rocktech.gads;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.Response;

import static com.rocktech.gads.ApiClient.retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class Learner extends Fragment {
    private static final String TAG = "Learner";

      private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    // private Context context;
//    private static final String TAG = "Learner";
//    RecyclerView learnerRec;

    public Learner() {
       // this.context = context;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learner, container, false);
        recyclerView = view.findViewById(R.id.learnerRec);
//        ArrayList<TopHour> topHours = new ArrayList<>();
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
//        recyclerView.setAdapter(adapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        try {
            Call<List<TopHour>> call = apiInterface.getTop();
            call.enqueue(new Callback<List<TopHour>>() {
                @Override
                public void onResponse(Call<List<TopHour>> call, Response<List<TopHour>> response) {
                    if (response.isSuccessful()){
                        ArrayList<TopHour> topHours = new ArrayList<>();
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
                        recyclerView.setAdapter(adapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(layoutManager);
                        List<TopHour> tops = response.body();
                        //
                        for (TopHour top : tops){
                            TopHour topUserHour;
                            topUserHour = new TopHour(top.getName(), top.getHours(), top.getCountry());
                            topHours.add(topUserHour);
                           // Log.d(TAG, "onResponse: Hours"+topUserHour.toString());
                        }
                        adapter.setUsers(topHours);
                    }
                }

                @Override
                public void onFailure(Call<List<TopHour>> call, Throwable t) {
                    Log.d(TAG, "onFailure: called"+t.getMessage());

                }
            });

        }catch (Exception e){
            Log.d(TAG, "onCreateView: failed"+e.getMessage());
        }

//        topHours.add(new TopHour("Musibawu Roqeeb", 5000, "hardexico.com","Nigeria"));
//        topHours.add(new TopHour("Musibawu Roqeeb Adelani", 8000, "hardexico.com","Nigeria"));

        return view;
       // return inflater.inflate(R.layout.fragment_learner, container, false);
    }

}
