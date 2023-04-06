package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;

public class TEST_EX extends AppCompatActivity {
    private RecyclerView recycler_t_ex;
    private FloatingActionButton btn_t_ex;
    private EditText edt_loaiSP,edt_maSP,edt_tenSP,edt_Sluong,edt_donGia,edt_hanSD;
    private T_EX_Adapter t_ex_adapter;
    private List<DTO_T_EX> arrayList = new ArrayList<>();
    private Button btn_tong,btn_tongLoaiSP;
    private TextView tv_tong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ex);
        recycler_t_ex = findViewById(R.id.recycler_t_ex);
        btn_t_ex = findViewById(R.id.action_btn_t_ex);
        btn_tong = findViewById(R.id.btn_tong);
        btn_tongLoaiSP = findViewById(R.id.btn_tongLoai);
        tv_tong = findViewById(R.id.tv_tong);


        LayoutInflater inflater = this.getLayoutInflater();
        View itemview = inflater.inflate(R.layout.dialog_add_t_ex, null);
        edt_loaiSP = itemview.findViewById(R.id.edt_loaisP);
        edt_maSP = itemview.findViewById(R.id.edt_masP);
        edt_tenSP = itemview.findViewById(R.id.edt_tensP);
        edt_Sluong = itemview.findViewById(R.id.edt_soLuong_tEx);
        edt_donGia = itemview.findViewById(R.id.edt_donGia_tEx);
        edt_hanSD = itemview.findViewById(R.id.edt_hanSD);


        t_ex_adapter = new T_EX_Adapter(getBaseContext());
        getDataKC();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recycler_t_ex.setLayoutManager(layoutManager);
        recycler_t_ex.setAdapter(t_ex_adapter);


        btn_t_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemview.getParent() != null) {
                    ((ViewGroup) itemview.getParent()).removeAllViews();
                }
                Dialog dialog = new Dialog(TEST_EX.this, androidx.appcompat.R.style.Base_Theme_AppCompat_Dialog_Alert);
                edt_loaiSP.setText("");
                edt_maSP.setText("");
                edt_tenSP.setText("");
                edt_Sluong.setText("");
                edt_donGia.setText("");
                edt_hanSD.setText("");
                dialog.setContentView(itemview);
                Button btn_add = dialog.findViewById(R.id.btn_addSP);
                Button btn_cancel = dialog.findViewById(R.id.btn_cancelSP);
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edt_loaiSP.getText().toString().trim().isEmpty()||edt_maSP.getText().toString().trim().isEmpty()||edt_tenSP.getText().toString().trim().isEmpty()||edt_Sluong.getText().toString().trim().isEmpty()||edt_donGia.getText().toString().trim().isEmpty()||edt_hanSD.getText().toString().trim().isEmpty()){
                            Toast.makeText(getBaseContext(), "Không được để trống thông tin", Toast.LENGTH_SHORT).show();
                        }else {
                            DTO_T_EX dtoTEx = new DTO_T_EX(edt_loaiSP.getText().toString(),edt_maSP.getText().toString(),edt_tenSP.getText().toString(),Integer.parseInt(edt_Sluong.getText().toString()),Integer.parseInt(edt_donGia.getText().toString()),edt_hanSD.getText().toString());
                            T_EX_DATA.getInstance(getBaseContext()).tExDao().insertObjTeX(dtoTEx);
                            getDataKC();
                            Toast.makeText(getBaseContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
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
                dialog.show();
            }
        });

        btn_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> tong = T_EX_DATA.getInstance(getBaseContext()).tExDao().listSP();
                if (tong.get(0)==null){
                    tv_tong.setText("0 VND");
                }else {
                    tv_tong.setText(tong.get(0)+" VND");
                }
            }
        });
        btn_tongLoaiSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),TongTeXActivity.class));
            }
        });
    }

    private void getDataKC() {
        arrayList = T_EX_DATA.getInstance(getBaseContext()).tExDao().getListObjSP();
        t_ex_adapter.setDataTeX(arrayList);
    }
}