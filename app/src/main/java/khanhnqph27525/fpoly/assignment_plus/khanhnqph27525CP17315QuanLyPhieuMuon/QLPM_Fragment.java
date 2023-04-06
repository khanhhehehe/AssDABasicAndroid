package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315QuanLyPhieuMuon;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonAdapter;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonEntity;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonSpinner2;
import khanhnqph27525.fpoly.assignment_plus.R;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachEntity;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien.Members;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien.MembersDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon.PhieuMuonSpinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QLPM_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QLPM_Fragment extends Fragment {
    private FloatingActionButton actionButton;
    private RecyclerView recyclerView;
    private List<PhieuMuonEntity> arrayList = new ArrayList<>();
    private List<Members> membersList = new ArrayList<>();
    private List<SachEntity> sachEntityList = new ArrayList<>();
    private PhieuMuonSpinner phieuMuonSpinner;
    private PhieuMuonSpinner2 phieuMuonSpinner2;
    private PhieuMuonAdapter phieuMuonAdapter;
    private Spinner spinner,spinner2;
    private Members members;
    private SachEntity sach;
    private int checkTra;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Button btn_phieuMuonNgay,btn_phieuMuonNgay2;

    public static QLPM_Fragment newInstance() {
        QLPM_Fragment fragment = new QLPM_Fragment();
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
        return inflater.inflate(R.layout.fragment_q_l_p_m_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        actionButton = view.findViewById(R.id.action_btn_phieuMuon);
        recyclerView = view.findViewById(R.id.recycler_phieuMuon);
        btn_phieuMuonNgay = view.findViewById(R.id.btn_phieuMuonNgay);
        btn_phieuMuonNgay2 = view.findViewById(R.id.btn_phieuMuonNgay2);
        LayoutInflater inflater = this.getLayoutInflater();
        View itemview = inflater.inflate(R.layout.dialog_add_phieumuon, null);
        spinner = itemview.findViewById(R.id.spinner_phieuMuon_TV);
        spinner2 = itemview.findViewById(R.id.spinner_phieuMuon_TS);
        phieuMuonAdapter = new PhieuMuonAdapter(getActivity());
        Calendar lich = Calendar.getInstance();
        getDataPM();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(phieuMuonAdapter);

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
                EditText edt_maPhieuMuon = itemview.findViewById(R.id.edt_maPhieuMuon);
                Button btn_cancel = itemview.findViewById(R.id.btn_cancel_PM);
                Button btn_add = itemview.findViewById(R.id.btn_add_PM);
                CheckBox chk = itemview.findViewById(R.id.chk_traSach);
                edt_maPhieuMuon.setText("");
                setSpinner();

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        members = membersList.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        members = membersList.get(0);
                    }
                });
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        sach = sachEntityList.get(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        sach = sachEntityList.get(0);
                    }
                });
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(edt_maPhieuMuon.getText().toString().trim().isEmpty()){
                            Toast.makeText(getContext(), "Không được để trống mã phiếu mượn", Toast.LENGTH_SHORT).show();
                        }else {
                            if (membersList.size()>0&&sachEntityList.size()>0){
                                if (members == null){
                                    members = membersList.get(0);
                                }else if (sach==null){
                                    sach = sachEntityList.get(0);
                                }
                                checkTra = (chk.isChecked()==true)?1:0;
                                int ngay= lich.get(Calendar.DATE);
                                int thang = lich.get(Calendar.MONTH);
                                int nam = lich.get(Calendar.YEAR);
                                GregorianCalendar c = new GregorianCalendar(nam,thang,ngay);
                                String date = sdf.format(c.getTime());
                                PhieuMuonEntity phieuMuon = new PhieuMuonEntity(Integer.parseInt(edt_maPhieuMuon.getText().toString()),members.getKhanhnqph27525CP17315tenthanhvien(),sach.getKhanhnqph27525CP17315tenSach(),sach.getKhanhnqph27525CP17315giaThue(),checkTra,date);
                                PhieuMuonDATA.getInstance(getContext()).phieuMuonDAO().insertObjPhieuMuon(phieuMuon);
                                getDataPM();
                                Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getContext(), "Không có thành viên hoặc sách nào để chọn", Toast.LENGTH_SHORT).show();
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
                dialog.show();
            }
        });
        btn_phieuMuonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = PhieuMuonDATA.getInstance(getContext()).phieuMuonDAO().listDT2("2022-01-01","2022-01-31");
                phieuMuonAdapter.setDataPM(arrayList);
            }
        });
        btn_phieuMuonNgay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = PhieuMuonDATA.getInstance(getContext()).phieuMuonDAO().listDT2("2020-12-20","2022-12-21");
                phieuMuonAdapter.setDataPM(arrayList);
            }
        });
    }

    private void setSpinner() {
        membersList = MembersDATA.getInstance(getContext()).membersDAO().getListObjMEM();
        phieuMuonSpinner = new PhieuMuonSpinner(getContext(),membersList,R.layout.item_spinner);
        spinner.setAdapter(phieuMuonSpinner);

        sachEntityList = SachDATA.getInstance(getContext()).sachDAO().getListObjS();
        phieuMuonSpinner2 = new PhieuMuonSpinner2(getContext(),sachEntityList,R.layout.item_spinner);
        spinner2.setAdapter(phieuMuonSpinner2);
    }

    private void getDataPM() {
        arrayList = PhieuMuonDATA.getInstance(getContext()).phieuMuonDAO().getListObjPM();
        phieuMuonAdapter.setDataPM(arrayList);
    }
}