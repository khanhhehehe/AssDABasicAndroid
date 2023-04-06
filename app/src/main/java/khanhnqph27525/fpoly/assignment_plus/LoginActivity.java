package khanhnqph27525.fpoly.assignment_plus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu.ThuThuDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThuThu.ThuThuEntity;

public class LoginActivity extends AppCompatActivity {
    private EditText edt_user,edt_pass;
    private CheckBox cbo_pass;
    private SharedPreferences sharedPreferences;
    private List<ThuThuEntity> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_user = findViewById(R.id.edt_taikhoan);
        edt_pass = findViewById(R.id.edt_matkhau);
        cbo_pass = findViewById(R.id.cbo_pass);
        arrayList = ThuThuDATA.getInstance(getBaseContext()).thuThuDAO().getListObjTT();

        sharedPreferences = getSharedPreferences("user_pass", Context.MODE_PRIVATE);

        String remember_user = sharedPreferences.getString("r_user","");
        String remember_pass = sharedPreferences.getString("r_pass","");
        boolean remember_chk = sharedPreferences.getBoolean("r_chk",false);

        if (remember_chk==true){
            edt_user.setText(remember_user);
            edt_pass.setText(remember_pass);
            cbo_pass.setChecked(true);
        }else {
            cbo_pass.setChecked(false);
        }

    }
    public void ClickMethod(View view){
        if(view.getId()==R.id.show_pass){
            if(edt_pass.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_remove_red_eye_24);

                edt_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_baseline_visibility_off_24);
                edt_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        }else if (view.getId()==R.id.btn_login){
            boolean chk = getDataThuThu();
            if (edt_user.getText().toString().trim().isEmpty()){
                Toast.makeText(this,"Không được để trống tài khoản",Toast.LENGTH_LONG).show();
            }else if (edt_pass.getText().toString().trim().isEmpty()){
                Toast.makeText(this,"Không được để trống mật khẩu",Toast.LENGTH_LONG).show();
            }else if (!(edt_user.getText().toString().equals("admin")&&edt_pass.getText().toString().equals("123456"))&&chk==false){
                Toast.makeText(this,"Tài khoản hoặc mật khẩu không hợp lệ",Toast.LENGTH_LONG).show();
            }else {
                String user = edt_user.getText().toString();
                String pass = edt_pass.getText().toString();
                boolean chk_cbo = cbo_pass.isChecked();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(chk_cbo==true){
                    editor.putString("r_user",user);
                    editor.putString("r_pass",pass);
                    editor.putBoolean("r_chk",chk_cbo);
                    editor.commit();
                }else{
                    editor.putBoolean("r_chk",chk_cbo);
                    editor.commit();
                }
                startActivity(new Intent(this,MainActivity.class));
                LoginActivity.this.finish();
            }
        }else if(view.getId()==R.id.btn_cancel){
            edt_user.setText("");
            edt_pass.setText("");
        }
    }
    public boolean getDataThuThu(){
        arrayList = ThuThuDATA.getInstance(getBaseContext()).thuThuDAO().getListObjTT();
        for (int i=0;i<arrayList.size();i++){
            if (edt_user.getText().toString().equals(arrayList.get(i).getKhanhnqph27525CP17315maTT())&&edt_pass.getText().toString().equals(arrayList.get(i).getKhanhnqph27525CP17315matKhau())){
                return true;
            }
        }
        return false;
    }
    private void set(){
        ThuThuEntity thu = new ThuThuEntity("khanhne","khanhhehehe","123");
        ThuThuDATA.getInstance(getBaseContext()).thuThuDAO().insertObjTT(thu);
        arrayList = ThuThuDATA.getInstance(getBaseContext()).thuThuDAO().getListObjTT();
    }
}