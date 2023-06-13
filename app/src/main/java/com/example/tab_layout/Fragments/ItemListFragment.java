package com.example.tab_layout.Fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tab_layout.R;
import com.example.tab_layout.RecyclerViewContents.AdapterListener;
import com.example.tab_layout.RecyclerViewContents.CustomAdapter;
import com.example.tab_layout.RoomDatabaseForItemList.ForItemDatabase;
import com.example.tab_layout.RoomDatabaseForItemList.Item;
import com.example.tab_layout.RoomDatabaseForItemList.ItemDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ItemListFragment extends Fragment implements AdapterListener {

    RecyclerView recyclerView;
    FloatingActionButton fl;
    public ForItemDatabase database;
    public ItemDAO itemDAO;
    public CustomAdapter itemAdapter;
    Handler handler;



    public ItemListFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_itemlist, container, false);

        //getting the instance from database

        database = ForItemDatabase.getInstance(getActivity());
        itemDAO = database.getItemDao();
        handler = new Handler();
        //initialize recycler view and setting the adapter
        recyclerView = view.findViewById(R.id.recycler);
        itemAdapter = new CustomAdapter(getActivity(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(itemAdapter);



        //creating a dialog for adding item to the database
        final Dialog dialog = new Dialog(getActivity(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.add_item);


        //floating action button work
        fl = view.findViewById(R.id.addingBtn);
        addWithFab(dialog);


        return view;
    }

    private void addWithFab(Dialog dialog) {

        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                TextView title,desc,img;
                Button add;
                add = dialog.findViewById(R.id.btnAddToDB);
                title = dialog.findViewById(R.id.addItemTitle);
                desc = dialog.findViewById(R.id.additemDesc);
                img = dialog.findViewById(R.id.imgLink);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Item item = new Item(title.getText().toString(),desc.getText().toString(),img.getText().toString());

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                itemDAO.addItem(item);
                                itemAdapter.addItem(item);
                            }
                        });

                        title.setText("");
                        desc.setText("");
                        img.setText("");
                        dialog.dismiss();
                    }
                });
            }


        });
    }

    private void fetchData()
    {

        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                List<Item> list = itemDAO.getAllItem();
                for(int i=0; i<list.size();i++)
                {
                    itemAdapter.addItem(list.get(i));
                }
            }
        });

    }


    @Override
    public void OnUpdate(Item item) {
        itemDAO.updateItem(item);
    }

    @Override
    public void OnDelete(Item item,int position) {
        itemDAO.deleteItem(item);
        itemAdapter.removeItem(position);
        Toast.makeText(getActivity(), "Item deleted successfully" +
                "", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        fetchData();
    }
}