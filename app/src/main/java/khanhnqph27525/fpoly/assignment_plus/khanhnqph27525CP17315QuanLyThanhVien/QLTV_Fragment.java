package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLyThanhVien;

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

import khanhnqph27525.fpoly.assignment_plus.R;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien.Members;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien.MembersAdapter;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien.MembersDATA;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QLTV_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QLTV_Fragment extends Fragment {
    private FloatingActionButton actionButton;
    private RecyclerView recyclerView;
    private List<Members> arrayList = new ArrayList<>();
    private MembersAdapter membersAdapter;
    private EditText edt_maTV,edt_tenTV,edt_namTV;

    public static QLTV_Fragment newInstance() {
        QLTV_Fragment fragment = new QLTV_Fragment();
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
        return inflater.inflate(R.layout.fragment_q_l_t_v_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        actionButton = view.findViewById(R.id.action_btn_thanhvien);
        recyclerView = view.findViewById(R.id.recycler_thanhvien);
        LayoutInflater inflater = this.getLayoutInflater();
        View itemview = inflater.inflate(R.layout.dialog_members, null);
        edt_maTV = itemview.findViewById(R.id.edt_mathanhvien);
        edt_tenTV = itemview.findViewById(R.id.edt_tenthanhvien);
        edt_namTV = itemview.findViewById(R.id.edt_namsinh);

        membersAdapter = new MembersAdapter(getActivity());
        getDataKC();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(membersAdapter);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemview.getParent() != null) {
                    ((ViewGroup) itemview.getParent()).removeAllViews();
                }
                Dialog dialog = new Dialog(getContext(), androidx.appcompat.R.style.Base_Theme_AppCompat_Dialog_Alert);
                edt_maTV.setText("");
                edt_tenTV.setText("");
                edt_namTV.setText("");
                dialog.setContentView(itemview);
                Button btn_add = dialog.findViewById(R.id.btn_add_thanhvien);
                Button btn_cancel = dialog.findViewById(R.id.btn_cancel_thanhvien);
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edt_maTV.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống mã", Toast.LENGTH_SHORT).show();
                        }else if (edt_tenTV.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống tên", Toast.LENGTH_SHORT).show();
                        }else if (edt_namTV.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống năm", Toast.LENGTH_SHORT).show();
                        }else {
                            Members members = new Members(Integer.parseInt(edt_maTV.getText().toString().trim()),edt_tenTV.getText().toString().trim(),edt_namTV.getText().toString().trim());
                            MembersDATA.getInstance(getContext()).membersDAO().insertObjmem(members);
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
        arrayList = MembersDATA.getInstance(getContext()).membersDAO().getListObjMEM();
        membersAdapter.setDataMEM(arrayList);
    }
}