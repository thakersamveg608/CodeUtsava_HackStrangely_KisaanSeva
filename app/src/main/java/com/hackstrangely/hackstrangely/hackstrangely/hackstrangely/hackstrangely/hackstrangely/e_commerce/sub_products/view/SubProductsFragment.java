package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.model.SubProductsData;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.presenter.SubProductsPresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.presenter.SubProductsPresenterImpl;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.sub_products.provider.RetrofitSubProductsProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubProductsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubProductsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubProductsFragment extends Fragment implements SubProductsView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SharedPrefs sharedPrefs;
    private SubProductsPresenter subProductsPresenter;
    private SubProductsAdapter subProductsAdapter;
    private GridLayoutManager gridLayoutManager;

    @BindView(R.id.sub_products_recycler)
    RecyclerView recyclerView_sub_products;

    @BindView(R.id.ProgressBar_sub_products)
    ProgressBar progressBar;

    private OnFragmentInteractionListener mListener;

    public SubProductsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubProductsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubProductsFragment newInstance(String param1, String param2) {
        SubProductsFragment fragment = new SubProductsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view =  inflater.inflate(R.layout.fragment_sub_products, container, false);
       sharedPrefs = new SharedPrefs(getContext());
       ButterKnife.bind(this, view);
        recyclerView_sub_products.setHasFixedSize(true);
        recyclerView_sub_products.setNestedScrollingEnabled(false);
        gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView_sub_products.setLayoutManager(gridLayoutManager);
        subProductsAdapter = new SubProductsAdapter(getContext());
        recyclerView_sub_products.setAdapter(subProductsAdapter);
        subProductsPresenter = new SubProductsPresenterImpl(this,new RetrofitSubProductsProvider());
        subProductsPresenter.requestSubProducts(sharedPrefs.getProduct(),sharedPrefs.getAccessToken());
       return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setSubProductsData(List<SubProductsData> subProductsList) {
            subProductsAdapter.setSubProductsDataList(subProductsList);
            subProductsAdapter.notifyDataSetChanged();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
