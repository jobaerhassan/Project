package com.example.tab_layout.RecyclerViewContents;


import com.example.tab_layout.RoomDatabaseForItemList.Item;

public interface AdapterListener {

    void OnUpdate(Item item);
    void OnDelete(Item item, int position);

}
