package com.eyeem.decorator.sample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eyeem.decorator.base_classes.AbstractDecorators;
import com.eyeem.decorator.exception.DecoratorNotFoundException;
import com.eyeem.recyclerviewtools.adapter.WrapAdapter;

import java.io.Serializable;

public class DecoratedAct extends AppCompatActivity {
   private AppCompatActivityDecorators decorators;

   public DecoratedAct() {
      super();
   }

   public final AppCompatActivityDecorators getDecorators() {
      return (AppCompatActivityDecorators)decorators;
   }

   public final void bind(AppCompatActivityDecorators.Builder builder) {
      try {
         decorators = (AppCompatActivityDecorators) builder.build();
         decorators.bind(this);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }

   public final void unbind() {
      decorators.unbind();
   }

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      decorators.onCreate(savedInstanceState);
   }

   @Override
   protected void onStart() {
      super.onStart();
      decorators.onStart();
   }

   @Override
   protected void onStop() {
      super.onStop();
      decorators.onStop();
   }

   @Override
   protected void onDestroy() {
      super.onDestroy();
      decorators.onDestroy();
   }

   protected void onViewInflated() {
      decorators.onViewInflated();
   }

   protected void onViewCreated() {
      decorators.onViewCreated();
   }

   public void setTitle(String title) {
      decorators.setTitle(title);
   }

   public void onUpClicked() {
      decorators.onUpClicked();
   }

   @LayoutRes
   public int getLayoutId() {
      try {
         return decorators.getLayoutId();
      } catch(DecoratorNotFoundException decoratorNotFoundException) {
         //region user inputed code
         return R.layout.recycler_view;
         //endregion
      }
   }

   public RecyclerView.LayoutManager getLayoutManager() {
      RecyclerView.LayoutManager obj = decorators.getLayoutManager();
      if (obj != null) {
         return obj;
      } else {
         //region user inputed code
         return new LinearLayoutManager(this);
         //endregion
      }
   }

   public RecyclerView.Adapter getAdapter() {
      RecyclerView.Adapter obj = decorators.getAdapter();
      if (obj != null) {
         return obj;
      } else {
         //region user inputed code
         return null;
         //endregion
      }
   }

   public void setupRecyclerView(RecyclerView recyclerView, WrapAdapter wrapAdapter, RecyclerView.Adapter adapter) {
      decorators.setupRecyclerView(recyclerView, wrapAdapter, adapter);
   }

   public static Builder getBuilder(Serializable serialized) {
      return (Builder) serialized;
   }

   public static class Builder extends AbstractDecorators.Builder<AppCompatActivity, Deco, Builder> {
      public Builder() {
         super(AppCompatActivityDecorators.class);
      }
   }
}
