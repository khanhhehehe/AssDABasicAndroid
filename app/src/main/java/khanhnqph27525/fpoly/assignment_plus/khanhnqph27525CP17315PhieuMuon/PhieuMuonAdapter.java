package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315PhieuMuon;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach.SachEntity;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien.Members;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien.MembersDATA;

public class PhieuMuonAdapter extends RecyclerView.Adapter<PhieuMuonAdapter.ObjPhieuMuonViewHolder>{
    private Context context;
    private List<PhieuMuonEntity> arrayList;
    private PhieuMuonEntity phieuMuonNew;
    private List<Members> membersList;
    private List<SachEntity> sachList;
    private PhieuMuonSpinner phieuMuonSpinner;
    private PhieuMuonSpinner2 phieuMuonSpinner2;
    private Spinner spinner,spinner2;
    private Members members;
    private SachEntity sach;
    private int checkTra;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public PhieuMuonAdapter(Context context) {
        this.context = context;
    }
    public void setDataPM(List<PhieuMuonEntity> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjPhieuMuonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phieumuon, parent, false);
        return new ObjPhieuMuonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjPhieuMuonViewHolder holder, int position) {
        PhieuMuonEntity phieuMuon = arrayList.get(position);
        if (phieuMuon == null) {
            return;
        }
        holder.maPhieu.setText(phieuMuon.getKhanhnqph27525CP17315maPM()+"");
        holder.thanhVien.setText(phieuMuon.getKhanhnqph27525CP17315tenTV());
        holder.tenSach.setText(phieuMuon.getKhanhnqph27525CP17315tenSach());
        holder.tienThue.setText(phieuMuon.getKhanhnqph27525CP17315tienThue()+" VND");
        holder.ngayThue.setText(phieuMuon.getKhanhnqph27525CP17315ngay());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa");
                builder.setMessage("Bạn có chắc muốn xóa không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PhieuMuonDATA.getInstance(v.getContext()).phieuMuonDAO().getObjidPM(phieuMuon.getKhanhnqph27525CP17315idphieuMuon());
                        arrayList = PhieuMuonDATA.getInstance(v.getContext()).phieuMuonDAO().getListObjPM();
                        setDataPM(arrayList);
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(context, "Hủy xóa", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
        if (phieuMuon.getKhanhnqph27525CP17315traSach()==1){
            holder.checkTra.setText("Đã trả");
            holder.checkTra.setTextColor(Color.parseColor("#00BFA5"));
        }else {
            holder.checkTra.setText("Chưa trả");
            holder.checkTra.setTextColor(Color.parseColor("#FF5252"));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Lựa chọn:");
                builder.setMessage("Bạn muốn sửa hay xem chi tiết?");
                builder.setPositiveButton("chi tiết", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog1 = new Dialog(v.getContext(), androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert);
                        dialog1.setContentView(R.layout.detail_phieumuon);
                        TextView tv_maPhieu = dialog1.findViewById(R.id.tv_maPM);
                        TextView tv_tenTV = dialog1.findViewById(R.id.tv_tenTV_PM);
                        TextView tv_tenSach = dialog1.findViewById(R.id.tv_tenSachPM);
                        TextView tv_tienThue = dialog1.findViewById(R.id.tv_tienThue_PM);
                        TextView tv_ngayThue = dialog1.findViewById(R.id.tv_ngayThue_PM);
                        TextView tv_traSach = dialog1.findViewById(R.id.tv_traSach_PM);
                        tv_maPhieu.setText(phieuMuon.getKhanhnqph27525CP17315maPM()+"");
                        tv_tenTV.setText(phieuMuon.getKhanhnqph27525CP17315tenTV());
                        tv_tenSach.setText(phieuMuon.getKhanhnqph27525CP17315tenSach());
                        tv_tienThue.setText(phieuMuon.getKhanhnqph27525CP17315tienThue()+"");
                        tv_ngayThue.setText(phieuMuon.getKhanhnqph27525CP17315ngay());
                        if (phieuMuon.getKhanhnqph27525CP17315traSach()==1){
                            tv_traSach.setText("Đã trả sách");
                            tv_traSach.setTextColor(Color.parseColor("#00BFA5"));
                        }else {
                            tv_traSach.setText("Chưa trả sách");
                            tv_traSach.setTextColor(Color.parseColor("#FF5252"));
                        }
                        dialog1.show();
                    }
                });
                builder.setNegativeButton("sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog2 = new Dialog(v.getContext(), androidx.appcompat.R.style.Base_Theme_AppCompat_Light_Dialog_Alert);
                        dialog2.setContentView(R.layout.dialog_update_phieumuon);

                        membersList = MembersDATA.getInstance(v.getContext()).membersDAO().getListObjMEM();
                        sachList = SachDATA.getInstance(v.getContext()).sachDAO().getListObjS();
                        Calendar lich = Calendar.getInstance();

                        EditText edt_maPhieuMuonNew = dialog2.findViewById(R.id.edt_maPhieuMuon_up);
                        spinner = dialog2.findViewById(R.id.spinner_phieuMuon_TV_up);
                        spinner2 = dialog2.findViewById(R.id.spinner_phieuMuon_TS_up);
                        CheckBox chk = dialog2.findViewById(R.id.chk_traSach_up);
                        Button btn_cancel = dialog2.findViewById(R.id.btn_cancel_PM_up);
                        Button btn_update = dialog2.findViewById(R.id.btn_update_PM_up);
                        edt_maPhieuMuonNew.setText(phieuMuon.getKhanhnqph27525CP17315maPM()+"");

                        phieuMuonSpinner = new PhieuMuonSpinner(v.getContext(), membersList,R.layout.item_spinner);
                        spinner.setAdapter(phieuMuonSpinner);
                        phieuMuonSpinner2 = new PhieuMuonSpinner2(v.getContext(), sachList,R.layout.item_spinner);
                        spinner2.setAdapter(phieuMuonSpinner2);

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
                                sach= sachList.get(position);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                                sach = sachList.get(0);
                            }
                        });
                        if (members == null){
                            members = membersList.get(0);
                        }
                        if (sach == null){
                            sach = sachList.get(0);
                        }

                        btn_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                            }
                        });
                        btn_update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(edt_maPhieuMuonNew.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống mã phiếu", Toast.LENGTH_SHORT).show();
                                }else{
                                    phieuMuonNew = phieuMuon;
                                    phieuMuonNew.setKhanhnqph27525CP17315maPM(Integer.parseInt(edt_maPhieuMuonNew.getText().toString()));
                                    phieuMuonNew.setKhanhnqph27525CP17315tenTV(members.getKhanhnqph27525CP17315tenthanhvien());
                                    phieuMuonNew.setKhanhnqph27525CP17315tenSach(sach.getKhanhnqph27525CP17315tenSach());
                                    phieuMuonNew.setKhanhnqph27525CP17315tienThue(sach.getKhanhnqph27525CP17315giaThue());
                                    checkTra = (chk.isChecked()==true)?1:0;
                                    phieuMuonNew.setKhanhnqph27525CP17315traSach(checkTra);
                                    int ngay= lich.get(Calendar.DATE);
                                    int thang = lich.get(Calendar.MONTH);
                                    int nam = lich.get(Calendar.YEAR);
                                    GregorianCalendar c = new GregorianCalendar(nam,thang,ngay);
                                    String date = sdf.format(c.getTime());
                                    phieuMuonNew.setKhanhnqph27525CP17315ngay(date);
                                    PhieuMuonDATA.getInstance(v.getContext()).phieuMuonDAO().updateObjPM(phieuMuonNew);
                                    arrayList = PhieuMuonDATA.getInstance(v.getContext()).phieuMuonDAO().getListObjPM();
                                    setDataPM(arrayList);
                                    Toast.makeText(v.getContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                                }
                                dialog2.dismiss();
                            }
                        });
                        dialog2.show();
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    public class ObjPhieuMuonViewHolder extends RecyclerView.ViewHolder{
        private TextView maPhieu;
        private TextView thanhVien;
        private TextView tenSach;
        private TextView tienThue;
        private TextView ngayThue;
        private TextView checkTra;
        private ImageView img_delete;
        public ObjPhieuMuonViewHolder(@NonNull View itemView) {
            super(itemView);
            maPhieu = itemView.findViewById(R.id.tv_maPhieu);
            thanhVien = itemView.findViewById(R.id.tv_thanhVien);
            tenSach = itemView.findViewById(R.id.tv_tenSach_PM);
            tienThue = itemView.findViewById(R.id.tv_tienThue);
            ngayThue = itemView.findViewById(R.id.tv_ngayThue);
            checkTra = itemView.findViewById(R.id.tv_checkTra);
            img_delete = itemView.findViewById(R.id.img_delete_PM);
        }
    }
}
