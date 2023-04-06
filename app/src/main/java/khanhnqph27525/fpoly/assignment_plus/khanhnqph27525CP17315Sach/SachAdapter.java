package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315Sach;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachDATA;
import khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315LoaiSach.LoaiSachEntity;
import khanhnqph27525.fpoly.assignment_plus.R;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ObjSachViewHolder>{
    private Context context;
    private List<SachEntity> arrayList;
    private SachEntity sachNew;
    private List<LoaiSachEntity> loaiSachlist;
    private SachSpinnerAdaper sachSpinnerAdaper;
    private Spinner spinner;
    private LoaiSachEntity loaiSach;

    public SachAdapter(Context context) {
        this.context = context;
    }
    public void setDataS(List<SachEntity> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjSachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sach, parent, false);
        return new ObjSachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjSachViewHolder holder, int position) {
        SachEntity sach = arrayList.get(position);
        if (sach == null) {
            return;
        }
        holder.maSach.setText(sach.getKhanhnqph27525CP17315maSach()+"");
        holder.tenSach.setText(sach.getKhanhnqph27525CP17315tenSach());
        holder.giaThue.setText(sach.getKhanhnqph27525CP17315giaThue()+"");
        holder.tacGia.setText(sach.getKhanhnqph27525CP17315tacGia());
        holder.loaiSach.setText(sach.getKhanhnqph27525CP17315tenLoai());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa");
                builder.setMessage("Bạn có chắc muốn xóa không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SachDATA.getInstance(v.getContext()).sachDAO().getObjidS(sach.getKhanhnqph27525CP17315idsach());
                        arrayList = SachDATA.getInstance(v.getContext()).sachDAO().getListObjS();
                        setDataS(arrayList);
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
                        dialog1.setContentView(R.layout.detail_sach);
                        TextView tv_ma = dialog1.findViewById(R.id.tv_maS);
                        TextView tv_ten = dialog1.findViewById(R.id.tv_tenS);
                        TextView tv_giaThue = dialog1.findViewById(R.id.tv_gThue);
                        TextView tv_tacGia = dialog1.findViewById(R.id.tv_tacGia_S);

                        TextView tv_loaiSach = dialog1.findViewById(R.id.tv_loaiSach_S);
                        tv_ma.setText(sach.getKhanhnqph27525CP17315maSach()+"");
                        tv_ten.setText(sach.getKhanhnqph27525CP17315tenSach());
                        tv_giaThue.setText(sach.getKhanhnqph27525CP17315giaThue()+"");
                        tv_tacGia.setText(sach.getKhanhnqph27525CP17315tacGia());
                        tv_loaiSach.setText(sach.getKhanhnqph27525CP17315tenLoai());
                        dialog1.show();
                    }
                });
                builder.setNegativeButton("sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog2 = new Dialog(v.getContext(), androidx.appcompat.R.style.Base_Theme_AppCompat_Light_Dialog_Alert);
                        dialog2.setContentView(R.layout.dialog_update_sach);

                        loaiSachlist = LoaiSachDATA.getInstance(v.getContext()).loaiSachDAO().getListObjLS();

                        EditText edt_maSach = dialog2.findViewById(R.id.edt_maSach_up);
                        EditText edt_tenSach = dialog2.findViewById(R.id.edt_tenSach_up);
                        EditText edt_giaThue = dialog2.findViewById(R.id.edt_giaThue_up);
                        EditText edt_tacGia = dialog2.findViewById(R.id.edt_tacGia_up);
                        spinner = dialog2.findViewById(R.id.spinner_sach_up);
                        Button btn_cancel = dialog2.findViewById(R.id.btn_cancel_Sach_up);
                        Button btn_update = dialog2.findViewById(R.id.btn_update_Sach);
                        edt_maSach.setText(sach.getKhanhnqph27525CP17315maSach()+"");
                        edt_tenSach.setText(sach.getKhanhnqph27525CP17315tenSach());
                        edt_giaThue.setText(sach.getKhanhnqph27525CP17315giaThue()+"");
                        edt_tacGia.setText(sach.getKhanhnqph27525CP17315tacGia());
                        sachSpinnerAdaper = new SachSpinnerAdaper(v.getContext(), loaiSachlist,R.layout.item_spinner);
                        spinner.setAdapter(sachSpinnerAdaper);

                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                loaiSach = loaiSachlist.get(position);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                                loaiSach = loaiSachlist.get(0);
                            }
                        });
                        if (loaiSach == null){
                            loaiSach = loaiSachlist.get(0);
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
                                if(edt_maSach.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống mã sách", Toast.LENGTH_SHORT).show();
                                }else if (edt_tenSach.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống tên sách", Toast.LENGTH_SHORT).show();
                                }else if (edt_giaThue.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống giá thuê", Toast.LENGTH_SHORT).show();
                                }else{
                                        sachNew = sach;
                                        sachNew.setKhanhnqph27525CP17315maSach(Integer.parseInt(edt_maSach.getText().toString()));
                                        sachNew.setKhanhnqph27525CP17315tenSach(edt_tenSach.getText().toString());
                                        sachNew.setKhanhnqph27525CP17315giaThue(Integer.parseInt(edt_giaThue.getText().toString()));
                                        sachNew.setKhanhnqph27525CP17315tacGia(edt_tacGia.getText().toString());
                                        sachNew.setKhanhnqph27525CP17315tenLoai(loaiSach.getKhanhnqph27525CP17315tenLoai());
                                        SachDATA.getInstance(v.getContext()).sachDAO().updateObjS(sachNew);
                                        arrayList = SachDATA.getInstance(v.getContext()).sachDAO().getListObjS();
                                        setDataS(arrayList);
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

    public class ObjSachViewHolder extends RecyclerView.ViewHolder{
        private TextView maSach;
        private TextView tenSach;
        private TextView giaThue;
        private TextView tacGia;
        private TextView loaiSach;
        private ImageView img_delete;
        public ObjSachViewHolder(@NonNull View itemView) {
            super(itemView);
            maSach = itemView.findViewById(R.id.tv_maSach);
            tenSach = itemView.findViewById(R.id.tv_tenSach);
            giaThue = itemView.findViewById(R.id.tv_giaThue);
            tacGia = itemView.findViewById(R.id.tv_tacGia);
            loaiSach = itemView.findViewById(R.id.tv_loaiSach);
            img_delete = itemView.findViewById(R.id.img_delete_S);
        }
    }
}
