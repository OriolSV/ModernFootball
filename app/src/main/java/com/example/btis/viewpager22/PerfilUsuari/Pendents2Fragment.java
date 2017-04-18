package com.example.btis.viewpager22.PerfilUsuari;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.btis.viewpager22.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pendents2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pendents2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pendents2Fragment extends Fragment {


    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public Pendents2Fragment() {
        // Required empty public constructor
    }

    public static Pendents2Fragment newInstance(int sectionNumber) {

        Pendents2Fragment fragment = new Pendents2Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        // Setup parámetros
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.fragment_tab1);

        // Inicializar lista


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pendents, container, false);

        List<Pendent> items = new ArrayList<>();

        items.add(new Pendent(R.drawable.hospi,R.drawable.cfbadalona, "CE L'Hospitalet", "Badalona CF", "21 d'abril", "19:30h" ));
        items.add(new Pendent(R.drawable.matorell,R.drawable.vaallirana, "Martorell FC", "Vallirana CF", "22 d'abril", "12:00h" ));
        items.add(new Pendent(R.drawable.hospi,R.drawable.cfbadalona, "CE L'Hospitalet", "Badalona CF", "21 d'abril", "19:30h" ));
        items.add(new Pendent(R.drawable.matorell,R.drawable.vaallirana, "Martorell FC", "Vallirana CF", "22 d'abril", "12:00h" ));
        items.add(new Pendent(R.drawable.hospi,R.drawable.cfbadalona, "CE L'Hospitalet", "Badalona CF", "21 d'abril", "19:30h" ));
        items.add(new Pendent(R.drawable.matorell,R.drawable.vaallirana, "Martorell FC", "Vallirana CF", "22 d'abril", "12:00h" ));
        items.add(new Pendent(R.drawable.hospi,R.drawable.cfbadalona, "CE L'Hospitalet", "Badalona CF", "21 d'abril", "19:30h" ));
        items.add(new Pendent(R.drawable.hospi,R.drawable.cfbadalona, "CE L'Hospitalet", "Badalona CF", "21 d'abril", "19:30h" ));
        items.add(new Pendent(R.drawable.hospi,R.drawable.cfbadalona, "CE L'Hospitalet", "Badalona CF", "21 d'abril", "19:30h" ));

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.reciclador);
        PendentAdaptador adapter = new PendentAdaptador(items);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);


        return rootView;
    }

}