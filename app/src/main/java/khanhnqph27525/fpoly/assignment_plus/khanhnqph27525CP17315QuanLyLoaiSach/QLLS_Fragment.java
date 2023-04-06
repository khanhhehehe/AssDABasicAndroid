package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLyLoaiSach;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachAdapter;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachEntity;
import khanhnqph27525.fpoly.assignment_plus.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QLLS_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QLLS_Fragment extends Fragment {
    private FloatingActionButton actionButton;
    private RecyclerView recyclerView;
    private List<LoaiSachEntity> arrayList = new ArrayList<>();
    private LoaiSachAdapter loaiSachAdapter;
    private EditText edt_maLS,edt_tenLS;

    public static QLLS_Fragment newInstance() {
        QLLS_Fragment fragment = new QLLS_Fragment();
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
        return inflater.inflate(R.layout.fragment_q_l_l_s_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        actionButton = view.findViewById(R.id.action_btn_loaisach);
        recyclerView = view.findViewById(R.id.recycler_loaisach);
        LayoutInflater inflater = this.getLayoutInflater();
        View itemview = inflater.inflate(R.layout.dialog_add_loaisach, null);
        edt_maLS = itemview.findViewById(R.id.edt_maSach);
        edt_tenLS = itemview.findViewById(R.id.edt_tenSach);

        loaiSachAdapter = new LoaiSachAdapter(getActivity());
        getDataKC();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(loaiSachAdapter);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemview.getParent() != null) {
                    ((ViewGroup) itemview.getParent()).removeAllViews();
                }
                Dialog dialog = new Dialog(getContext(), androidx.appcompat.R.style.Base_Theme_AppCompat_Dialog_Alert);
                edt_maLS.setText("");
                edt_tenLS.setText("");
                dialog.setContentView(itemview);
                Button btn_add = dialog.findViewById(R.id.btn_add_loaiSach);
                Button btn_cancel = dialog.findViewById(R.id.btn_cancel_loaiSach);
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edt_maLS.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống mã", Toast.LENGTH_SHORT).show();
                        }else if (edt_tenLS.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống tên", Toast.LENGTH_SHORT).show();
                        }else {
                            LoaiSachEntity loaiSach = new LoaiSachEntity(Integer.parseInt(edt_maLS.getText().toString().trim()),edt_tenLS.getText().toString().trim());
                            LoaiSachDATA.getInstance(getContext()).loaiSachDAO().insertObjLoaiSach(loaiSach);
                            getDataKC();
                            Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                });
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
    }

    private void getDataKC() {
        arrayList = LoaiSachDATA.getInstance(getContext()).loaiSachDAO().getListObjLS();
        loaiSachAdapter.setDataLS(arrayList);
    }
}