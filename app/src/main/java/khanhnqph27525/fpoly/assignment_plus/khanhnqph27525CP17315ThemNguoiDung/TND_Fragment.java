package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThemNguoiDung;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import khanhnqph27525.fpoly.assignment_plus.R;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu.ThuThuDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu.ThuThuEntity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TND_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TND_Fragment extends Fragment implements View.OnClickListener {
    private EditText edt_maTT,edt_hoTen,edt_passTT,edt_pass2TT;
    private Button btn_cancel,btn_add;
    private ImageView show_pass,show_pass2;
    public static TND_Fragment newInstance() {
        TND_Fragment fragment = new TND_Fragment();
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
        return inflater.inflate(R.layout.fragment_t_n_d_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edt_maTT = view.findViewById(R.id.edt_tenDangNhap);
        edt_hoTen = view.findViewById(R.id.edt_hoTen);
        edt_passTT = view.findViewById(R.id.edt_passTT);
        edt_pass2TT = view.findViewById(R.id.edt_passConfirmTT);
        show_pass = view.findViewById(R.id.show_passTND);
        show_pass.setOnClickListener(this);
        show_pass2 = view.findViewById(R.id.show_pass2TND);
        show_pass2.setOnClickListener(this);
        btn_cancel = view.findViewById(R.id.btn_cancel_TT);
        btn_add = view.findViewById(R.id.btn_addTT);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_maTT.setText("");
                edt_hoTen.setText("");
                edt_passTT.setText("");
                edt_pass2TT.setText("");
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_maTT.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "Không được để trống tên đăng nhập", Toast.LENGTH_SHORT).show();
                }else if (edt_hoTen.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "Không được để trống họ tên", Toast.LENGTH_SHORT).show();
                }else if (edt_passTT.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
                }else if (edt_pass2TT.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(), "Không được để trống xác nhận mật khẩu", Toast.LENGTH_SHORT).show();
                }else if (!edt_passTT.getText().toString().equals(edt_pass2TT.getText().toString())){
                    Toast.makeText(getContext(), "Mật khẩu xác nhận không chính xác", Toast.LENGTH_SHORT).show();
                }else {
                    ThuThuEntity thuThu = new ThuThuEntity(edt_maTT.getText().toString(),edt_hoTen.getText().toString(),edt_pass2TT.getText().toString());
                    ThuThuDATA.getInstance(getContext()).thuThuDAO().insertObjTT(thuThu);
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    edt_passTT.setText("");
                    edt_maTT.setText("");
                    edt_hoTen.setText("");
                    edt_pass2TT.setText("");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_passTND:
                if(edt_passTT.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                    edt_passTT.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    edt_passTT.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.show_pass2TND:
                if(edt_pass2TT.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                    edt_pass2TT.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    edt_pass2TT.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }
}