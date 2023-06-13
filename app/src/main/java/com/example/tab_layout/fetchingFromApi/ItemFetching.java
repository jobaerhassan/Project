package com.example.tab_layout.fetchingFromApi;

import java.util.ArrayList;
import java.util.List;

public class ItemFetching {
    public static List<ItemForApi> getItemList() {
        // Simulate API call and return item data or throw an exception
        List<ItemForApi> items = new ArrayList<>();
        items.add(new ItemForApi(1, "Item 1","desc", "https://link"));
        items.add(new ItemForApi(1, "Item 1","desc", "https://link"));
        // ...
        return items;
    }

//    public static ItemForApi addItem(ItemForApi item) {
//
//        // Simulate API call and return the added item or throw an exception
////        ItemForApi newItem = new ItemForApi();
//    }

    public static void deleteItem(long itemId) {
        // Simulate API call to delete item or throw an exception
        // ...
    }

//    public static Profile getProfileInfo() {
//        // Simulate API call and return profile data or throw an exception
//        Profile profile = new Profile("John Doe", "john@example.com");
//        // ...
//        return profile;
//    }
}
