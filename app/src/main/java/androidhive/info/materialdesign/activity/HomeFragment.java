package androidhive.info.materialdesign.activity;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import androidhive.info.materialdesign.R;
import androidhive.info.materialdesign.adapter.LazyAdapterPakej;


public class HomeFragment extends Fragment {


    ArrayList<HashMap<String, String>> songsList;
    LazyAdapterPakej adapter;
    private ProgressDialog Dialog;
    ListView lv;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news_layout, container, false);

        lv = (ListView)rootView.findViewById(R.id.lv);
        songsList = new ArrayList<HashMap<String, String>>();
        Dialog = new ProgressDialog(getActivity());

        new GetMemberPackage().execute();

        // Inflate the layout for this fragment
        return rootView;
    }


    // Class with extends AsyncTask class
    private class GetMemberPackage extends AsyncTask<String, Void, Void> {


        // Call after onPreExecute method
        protected Void doInBackground(String... urls) {



            return null;
        }

        protected void onPostExecute(Void unused) {
            // Close progress dialog
            //Dialog.dismiss();

            adapter = new LazyAdapterPakej(getActivity(), songsList);
            lv.setAdapter(adapter);

            // Click event for single list row
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        final int position, long id) {

//                            HashMap<String, String> song = new HashMap<String, String>();
//                            song = songsList.get(position);
//
//                            //Starting new intent
//                            Intent in = new Intent(getActivity().getApplicationContext(), ViewDetailsPackage.class);
//
//                            in.putExtra(TAG_ID, song.get(DealsFragment.TAG_ID));
//                            in.putExtra(TAG_PAYMENT_STATUS, song.get(DealsFragment.TAG_PAYMENT_STATUS));
//                            in.putExtra(TAG_MEMBER_PACKAGE_ID, song.get(DealsFragment.TAG_MEMBER_PACKAGE_ID));
//                            in.putExtra(TAG_DJ_REF, song.get(DealsFragment.TAG_DJ_REF));
//
//                            startActivityForResult(in, VIEW_DETAILS_REQ);

                }
            });
        }

    }//End long Task

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
