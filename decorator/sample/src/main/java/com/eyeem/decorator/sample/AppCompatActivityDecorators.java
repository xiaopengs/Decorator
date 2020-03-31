package com.eyeem.decorator.sample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.eyeem.decorator.base_classes.AbstractDecorators;
import com.eyeem.decorator.exception.DecoratorNotFoundException;
import com.eyeem.recyclerviewtools.adapter.WrapAdapter;

import io.realm.RealmList;
import io.realm.RealmObject;

public final class AppCompatActivityDecorators extends AbstractDecorators<AppCompatActivity, Deco, DecoratedAct.Builder> {
   private static final Class[] NON_COMPOSABLE = {
   Deco.InstigateGetLayoutId.class, 
   Deco.InstigateGetLayoutManager.class, 
   Deco.InstigateGetAdapter.class, 
   Deco.DataInstigator.class, 
   Deco.RequestInstigator.class, 
   Deco.HeaderInstigator.class
   };

   public AppCompatActivityDecorators(DecoratedAct.Builder builder) throws InstantiationException, IllegalAccessException {
      super(builder);
   }

   public final void onCreate(@Nullable Bundle savedInstanceState) {
      for (int i = 0; i < size; i++) {
         decorators.get(i).onCreate(savedInstanceState);
      }
   }

   public final void onStart() {
      for (int i = 0; i < size; i++) {
         decorators.get(i).onStart();
      }
   }

   public final void onStop() {
      for (int i = 0; i < size; i++) {
         decorators.get(i).onStop();
      }
   }

   public final void onDestroy() {
      for (int i = 0; i < size; i++) {
         decorators.get(i).onDestroy();
      }
   }

   public final void onViewInflated() {
      for (int i = 0; i < size; i++) {
         decorators.get(i).onViewInflated();
      }
   }

   public final void onViewCreated() {
      for (int i = 0; i < size; i++) {
         decorators.get(i).onViewCreated();
      }
   }













   public final void setTitle(String title) {
      for (int i = 0; i < size; i++) {
         decorators.get(i).setTitle(title);
      }
   }

   public final void onUpClicked() {
      for (int i = 0; i < size; i++) {
         decorators.get(i).onUpClicked();
      }
   }

   @LayoutRes
   public final int getLayoutId() {
      Deco.InstigateGetLayoutId deco = getInstigator(Deco.InstigateGetLayoutId.class);
      if (deco != null) {
         return deco.getLayoutId();
      } else {
         throw new DecoratorNotFoundException();
      }
   }

   public final RecyclerView.LayoutManager getLayoutManager() {
      Deco.InstigateGetLayoutManager deco = getInstigator(Deco.InstigateGetLayoutManager.class);
      if (deco != null) {
         return deco.getLayoutManager();
      } else {
         return null;
      }
   }

   public final RecyclerView.Adapter getAdapter() {
      Deco.InstigateGetAdapter deco = getInstigator(Deco.InstigateGetAdapter.class);
      if (deco != null) {
         return deco.getAdapter();
      } else {
         return null;
      }
   }

   public final void setupRecyclerView(RecyclerView recyclerView, WrapAdapter wrapAdapter, RecyclerView.Adapter adapter) {
      for (int i = 0; i < size; i++) {
         decorators.get(i).setupRecyclerView(recyclerView, wrapAdapter, adapter);
      }
   }

   public final void inflateMenu(Toolbar toolbar) {
      for (int i = 0; i < size; i++) {
         Deco deco = decorators.get(i);
         if (deco instanceof Deco.MenuDecorator) {
            ((Deco.MenuDecorator) deco).inflateMenu(toolbar);
         }
      }
   }

   public final boolean onMenuItemClick(MenuItem item) {
      for (int i = 0; i < size; i++) {
         Deco deco = decorators.get(i);
         if (deco instanceof Deco.MenuDecorator) {
            if (((Deco.MenuDecorator) deco).onMenuItemClick(item)) {
               return true;
            }
         }
      }
      return false;
   }

   public final RealmList getList() {
      Deco.DataInstigator deco = getInstigator(Deco.DataInstigator.class);
      if (deco != null) {
         return ((Deco.DataInstigator) deco).getList();
      } else {
         return null;
      }
   }

   public final RealmObject getModel() {
      Deco.DataInstigator deco = getInstigator(Deco.DataInstigator.class);
      if (deco != null) {
         return ((Deco.DataInstigator) deco).getModel();
      } else {
         return null;
      }
   }

   public final String getRequestId() {
      Deco.RequestInstigator deco = getInstigator(Deco.RequestInstigator.class);
      if (deco != null) {
         return ((Deco.RequestInstigator) deco).getRequestId();
      } else {
         return null;
      }
   }

   public final void reload() {
      Deco.RequestInstigator deco = getInstigator(Deco.RequestInstigator.class);
      if (deco != null) {
         ((Deco.RequestInstigator) deco).reload();
      }
   }

   public final void loadMore() {
      Deco.RequestInstigator deco = getInstigator(Deco.RequestInstigator.class);
      if (deco != null) {
         ((Deco.RequestInstigator) deco).loadMore();
      }
   }

   public final int getHeaderId() {
      Deco.HeaderInstigator deco = getInstigator(Deco.HeaderInstigator.class);
      if (deco != null) {
         return ((Deco.HeaderInstigator) deco).getHeaderId();
      } else {
         return 0;
      }
   }

   public final void onHeaderCreated(CollapsingToolbarLayout collapsingToolbarLayout) {
      Deco.HeaderInstigator deco = getInstigator(Deco.HeaderInstigator.class);
      if (deco != null) {
         ((Deco.HeaderInstigator) deco).onHeaderCreated(collapsingToolbarLayout);
      }
   }

   @Override
   protected final Class[] getNonComposable() {
      return NON_COMPOSABLE;
   }
}
