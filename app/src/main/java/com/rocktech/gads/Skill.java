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
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Skill extends Fragment {
   private ApiInterface apiInterface;
    private String name,country,url;
    private int score;
    private RecyclerView recyclerView;
    private static final String TAG = "Skill";
    // ArrayList<User> userArrayList;
   // User user1;
    public Skill() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.list_skill, container, false);
        View view = inflater.inflate(R.layout.fragment_skill, container, false);
        recyclerView = view.findViewById(R.id.skillRec);


        apiInterface = ApiClient.getClient().create(ApiInterface.class);

            Call<List<User>> call = apiInterface.getAll();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful()){
                        ArrayList<User> userArrayList = new ArrayList<>();
                        SkillViewAdapter adapter = new SkillViewAdapter();
                        recyclerView.setAdapter(adapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(layoutManager);
                       List<User> users = response.body();
                        //userArrayList.addAll(users);
//
                        for (User user : users){
                            User user1;
                            name = user.getName();
                            score = user.getHours();
                            country = user.getCountry();
                            user1 = new User(name,score,country);
                            userArrayList.add(user1);
                             Log.d(TAG, "onResponse: called "+user1.toString());
                        }
//                        userArrayList.add(new User(name, score,country));
//                        userArrayList.add(new User("Roqeeb Adelani", 800, "hardexico.com","Ghana"));

                        adapter.setUsers(userArrayList);

                    }
                }
                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.d(TAG, "onFailure: failed"+t.getMessage());
                }
            });
           // adapter.setUsers(userArrayList);
       // users.retainAll(users);

        return view;
    }

}
