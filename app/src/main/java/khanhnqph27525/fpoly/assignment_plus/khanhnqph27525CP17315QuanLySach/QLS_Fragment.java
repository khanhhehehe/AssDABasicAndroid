package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLySach;

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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachEntity;
import khanhnqph27525.fpoly.assignment_plus.R;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachAdapter;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachEntity;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachSpinnerAdaper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QLS_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QLS_Fragment extends Fragment {
    private FloatingActionButton actionButton;
    private RecyclerView recyclerView;
    private List<SachEntity> arrayList = new ArrayList<>();
    private List<LoaiSachEntity> loaiSachList = new ArrayList<>();
    private SachSpinnerAdaper sachSpinnerAdaper;
    private SachAdapter sachAdapter;
    private Spinner spinner;
    private LoaiSachEntity loaiSach;
    private Button btn_timKiem;

    public static QLS_Fragment newInstance() {
        QLS_Fragment fragment = new QLS_Fragment();
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
        return inflater.inflate(R.layout.fragment_q_l_s_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        actionButton = view.findViewById(R.id.action_btn_sach);
        recyclerView = view.findViewById(R.id.recycler_sach);
        btn_timKiem = view.findViewById(R.id.btn_timKiem);

        LayoutInflater inflater = this.getLayoutInflater();
        View itemview = inflater.inflate(R.layout.dialog_sach, null);
        spinner = itemview.findViewById(R.id.spinner_sach);
        sachAdapter = new SachAdapter(getActivity());
        getDataKT();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sachAdapter);

        setSpinner();
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemview.getParent() != null) {
                    ((ViewGroup) itemview.getParent()).removeAllViews();
                }
                Dialog dialog = new Dialog(getContext(), androidx.appcompat.R.style.Base_Theme_AppCompat_Dialog_Alert);
                setSpinner();
                dialog.setContentView(itemview);
                EditText edt_maSach = itemview.findViewById(R.id.edt_maSach);
                EditText edt_tenSach = itemview.findViewById(R.id.edt_tenSach);
                EditText edt_giaThue = itemview.findViewById(R.id.edt_giaThue);
                EditText edt_tacGia = itemview.findViewById(R.id.edt_tacGia);
                Button btn_cancel = itemview.findViewById(R.id.btn_cancel_Sach);
                Button btn_add = itemview.findViewById(R.id.btn_add_Sach);
                edt_maSach.setText("");
                edt_tenSach.setText("");
                edt_giaThue.setText("");
                edt_tacGia.setText("");

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        loaiSach = loaiSachList.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        loaiSach = loaiSachList.get(0);
                    }
                });

                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edt_maSach.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống mã sách", Toast.LENGTH_SHORT).show();
                        }else if (edt_tenSach.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống tên sách", Toast.LENGTH_SHORT).show();
                        }else if (edt_giaThue.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống giá thuê", Toast.LENGTH_SHORT).show();
                        }else if (edt_tacGia.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống tác giả", Toast.LENGTH_SHORT).show();
                        }else{
                            if (loaiSachList.size()>0){
                                if (loaiSach == null){
                                    loaiSach = loaiSachList.get(0);
                                }
                                SachEntity sach = new SachEntity(Integer.parseInt(edt_maSach.getText().toString()),edt_tenSach.getText().toString(),Integer.parseInt(edt_giaThue.getText().toString()),loaiSach.getKhanhnqph27525CP17315tenLoai(),edt_tacGia.getText().toString());
                                SachDATA.getInstance(getContext()).sachDAO().insertObjSach(sach);
                                getDataKT();
                                Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getContext(), "Không có loại sách nào để chọn", Toast.LENGTH_SHORT).show();
                            }
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
        btn_timKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = SachDATA.getInstance(getContext()).sachDAO().getSachMa("IT");
                sachAdapter.setDataS(arrayList);
            }
        });
    }

    private void setSpinner() {
        loaiSachList = LoaiSachDATA.getInstance(getContext()).loaiSachDAO().getListObjLS();
        sachSpinnerAdaper = new SachSpinnerAdaper(getContext(),loaiSachList,R.layout.item_spinner);
        spinner.setAdapter(sachSpinnerAdaper);
    }

    private void getDataKT() {
        arrayList = SachDATA.getInstance(getContext()).sachDAO().getListObjS();
        sachAdapter.setDataS(arrayList);
    }
}