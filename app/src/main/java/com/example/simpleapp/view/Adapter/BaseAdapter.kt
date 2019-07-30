package com.example.simpleapp.view.Adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<MovieAdapter.BindingHolder>(),IAdapter<T>