package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315SachMuonNhieu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonEntity;
import khanhnqph27525.fpoly.assignment_plus.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SMN_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SMN_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private List<ThongKe> thongKeList = new ArrayList<>();
    private List<PhieuMuonEntity> phieuMuonEntityList = new ArrayList<>();
    private ThongKeAdapter thongKeAdapter;
    public static SMN_Fragment newInstance() {
        SMN_Fragment fragment = new SMN_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s_m_n_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_thongke);
        thongKeAdapter = new ThongKeAdapter(getActivity());
        thongKeList = PhieuMuonDATA.getInstance(getContext()).phieuMuonDAO().loadAll();

        thongKeAdapter.setDataTK(thongKeList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(thongKeAdapter);
    }
}