package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315DoiMatKhau;

import android.content.Context;
import android.content.SharedPreferences;
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

import java.util.ArrayList;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu.ThuThuDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu.ThuThuEntity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DMK_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DMK_Fragment extends Fragment implements View.OnClickListener {
    private EditText edt_passOld,edt_passNew,edt_passNewConfirm;
    private Button btn_cancel,btn_update;
    private SharedPreferences sharedPreferences;
    private List<ThuThuEntity> arrayList = new ArrayList<>();
    private ThuThuEntity thuThu;
    private ImageView show_pass,show_pass2,show_pass3;
    public static DMK_Fragment newInstance() {
        DMK_Fragment fragment = new DMK_Fragment();
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
        return inflater.inflate(R.layout.fragment_d_m_k_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edt_passOld = view.findViewById(R.id.edt_passOld);
        edt_passNew = view.findViewById(R.id.edt_passNew);
        edt_passNewConfirm = view.findViewById(R.id.edt_passNewConfirm);
        show_pass = view.findViewById(R.id.show_pass);
        show_pass.setOnClickListener(this);
        show_pass2 = view.findViewById(R.id.show_pass2);
        show_pass2.setOnClickListener(this);
        show_pass3 = view.findViewById(R.id.show_pass3);
        show_pass3.setOnClickListener(this);
        btn_cancel = view.findViewById(R.id.btn_cancel_matKhau);
        btn_update = view.findViewById(R.id.btn_update_matKhau);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_passOld.setText("");
                edt_passNew.setText("");
                edt_passNewConfirm.setText("");
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getContext().getSharedPreferences("user_pass", Context.MODE_PRIVATE);
                String user = sharedPreferences.getString("r_user","");
                String passOld = sharedPreferences.getString("r_pass","");

                if (edt_passOld.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(),"Không được để trống mật khẩu cũ",Toast.LENGTH_LONG).show();
                }else if (edt_passNew.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(),"Không được để trống mật khẩu mới",Toast.LENGTH_LONG).show();
                }else if (edt_passNewConfirm.getText().toString().trim().isEmpty()){
                    Toast.makeText(getContext(),"Không được để trống xác nhận mật khẩu",Toast.LENGTH_LONG).show();
                }else if (!edt_passOld.getText().toString().equals(passOld)){
                    Toast.makeText(getContext(), "Mật khẩu cũ không hợp lệ", Toast.LENGTH_SHORT).show();
                }else if (user.equals("admin")&&passOld.equals("123456")){
                    Toast.makeText(getContext(), "Tài khoản Admin không thể thay đổi mật khẩu", Toast.LENGTH_SHORT).show();
                }else {
                    arrayList = ThuThuDATA.getInstance(getContext()).thuThuDAO().getListObjTT();
                    for (int i=0;i<arrayList.size();i++){
                        if (user.equals(arrayList.get(i).getKhanhnqph27525CP17315maTT())&&passOld.equals(arrayList.get(i).getKhanhnqph27525CP17315matKhau())){
                            thuThu = arrayList.get(i);
                        }
                    }
                    thuThu.setKhanhnqph27525CP17315matKhau(edt_passNewConfirm.getText().toString());
                    ThuThuDATA.getInstance(v.getContext()).thuThuDAO().updateObjTT(thuThu);
                    arrayList = ThuThuDATA.getInstance(v.getContext()).thuThuDAO().getListObjTT();
                    Toast.makeText(getContext(),"Thay đổi mật khẩu thành công",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_pass:
                if(edt_passOld.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                    edt_passOld.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    edt_passOld.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.show_pass2:
                if(edt_passNew.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                    edt_passNew.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    edt_passNew.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.show_pass3:
                if(edt_passNewConfirm.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                    edt_passNewConfirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    ((ImageView)(v)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    edt_passNewConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }
}