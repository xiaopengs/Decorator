package com.eyeem.decorator.sample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.eyeem.decorator.base_classes.AbstractDecorator;
import com.eyeem.recyclerviewtools.adapter.WrapAdapter;

import io.realm.RealmList;
import io.realm.RealmObject;

public abstract class Deco extends AbstractDecorator<AppCompatActivity> {
   protected final AppCompatActivityDecorators getDecorators() {
      return (AppCompatActivityDecorators)decorators;
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
   }

   protected void onStart() {
   }

   protected void onStop() {
   }

   protected void onDestroy() {
   }

   protected void onViewInflated() {
   }

   protected void onViewCreated() {
   }

   public void setTitle(String title) {
   }

   public void onUpClicked() {
   }

   public void setupRecyclerView(RecyclerView recyclerView, WrapAdapter wrapAdapter, RecyclerView.Adapter adapter) {
   }

   public interface InstigateGetLayoutId {
      @LayoutRes
      int getLayoutId();
   }

   public interface InstigateGetLayoutManager {
      RecyclerView.LayoutManager getLayoutManager();
   }

   public interface InstigateGetAdapter {
      RecyclerView.Adapter getAdapter();
   }

   public interface MenuDecorator {
      void inflateMenu(Toolbar toolbar);

      boolean onMenuItemClick(MenuItem item);
   }

   public interface DataInstigator {
      RealmList getList();

      RealmObject getModel();
   }

   public interface RequestInstigator {
      String getRequestId();

      void reload();

      void loadMore();
   }

   public interface HeaderInstigator {
      int getHeaderId();

      void onHeaderCreated(CollapsingToolbarLayout collapsingToolbarLayout);
   }
}
