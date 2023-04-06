package khanhnqph27525.fpoly.assignment_plus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315DoanhThu.DT_Fragment;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315DoiMatKhau.DMK_Fragment;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLyLoaiSach.QLLS_Fragment;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLyPhieuMuon.QLPM_Fragment;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLySach.QLS_Fragment;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLyThanhVien.QLTV_Fragment;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315SachMuonNhieu.SMN_Fragment;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThemNguoiDung.TND_Fragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        toggle.syncState();
        navigationView = findViewById(R.id.id_navigation);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(QLPM_Fragment.newInstance());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        if (i==R.id.quanlyphieumuon){
            replaceFragment(QLPM_Fragment.newInstance());
        }else if(i==R.id.quanlyloaisach){
            replaceFragment(QLLS_Fragment.newInstance());
        }else if (i==R.id.quanlysach){
            replaceFragment(QLS_Fragment.newInstance());
        }else if (i==R.id.quanlythanhvien){
            replaceFragment(QLTV_Fragment.newInstance());
        }else if (i==R.id.sachmuonnhieu){
            replaceFragment(SMN_Fragment.newInstance());
        }else if (i==R.id.doanhthu){
            replaceFragment(DT_Fragment.newInstance());
        }else if (i==R.id.themnguoidung){
            replaceFragment(TND_Fragment.newInstance());
        }else if (i==R.id.doimatkhau){
            replaceFragment(DMK_Fragment.newInstance());
        }else if (i==R.id.dangxuat){
            AlertDialog.Builder builder =  new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Thoát");
            builder.setMessage("Bạn có chắc muốn đăng xuất không?");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.this.finish();
                    startActivity(new Intent(getBaseContext(),LoginActivity.class));
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create();
            builder.show();
        }
        drawerLayout.closeDrawer(navigationView);
        return true;
    }
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_content, fragment);
        transaction.commit();
    }
}