package brostore.maquillage.view;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import brostore.maquillage.R;
import brostore.maquillage.adapter.OrdersAdapter;
import brostore.maquillage.manager.OrderManager;

/**
 * Created by Michaos on 11/07/2015.
 */
public class FragmentMesCommandes extends Fragment {

    private View rootView;

    private BroadcastReceiver broadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            System.out.println("AAAA " +  intent.getAction());

            if (intent.getAction().equals("OK ORDERS")) {
                init();
            } else if (intent.getAction().equals("KO ORDERS")) {

            }else if(intent.getAction().equals("NO ORDERS")){
                rootView.findViewById(R.id.progress).setVisibility(View.GONE);
                ((TextView)rootView.findViewById(R.id.chargement)).setText(R.string.no_orders);
            }
        }
    };


    public FragmentMesCommandes() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_mes_commandes, container, false);

        IntentFilter filter = new IntentFilter();
        filter.addAction("OK ORDERS");
        filter.addAction("KO ORDERS");
        filter.addAction("NO ORDERS");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(broadCastReceiver, filter);

        OrderManager.getInstance(getActivity()).getUserOrders();

        return rootView;
    }

    private void init() {

        rootView.findViewById(R.id.loadinglayout).setVisibility(View.GONE);
        rootView.findViewById(R.id.listView).setVisibility(View.VISIBLE);

        ListView myListView = (ListView) rootView.findViewById(R.id.listView);
        myListView.setAdapter(new OrdersAdapter(getActivity(), OrderManager.getInstance(getActivity()).getListOrders()));
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public void onDestroy() {
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(broadCastReceiver);
        super.onDestroy();
    }
}
