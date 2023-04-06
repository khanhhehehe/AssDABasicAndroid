package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315ThanhVien;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ObjMembersViewHolder>{
    private Context context;
    private List<Members> arrayList;
    private Members membersnew;

    public MembersAdapter(Context context) {
        this.context = context;
    }
    public void setDataMEM(List<Members> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ObjMembersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thanhvien, parent, false);
        return new ObjMembersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjMembersViewHolder holder, int position) {
        Members members = arrayList.get(position);
        if (members == null) {
            return;
        }
        holder.maThanhVien.setText(arrayList.get(position).getKhanhnqph27525CP17315maTV()+"");
        holder.hotenThanhVien.setText(arrayList.get(position).getKhanhnqph27525CP17315tenthanhvien());
        holder.date.setText(arrayList.get(position).getKhanhnqph27525CP17315namsinh());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Xóa");
                builder.setMessage("Bạn có chắc muốn xóa không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MembersDATA.getInstance(v.getContext()).membersDAO().getObjidMEM(members.getKhanhnqph27525CP17315idthanhvien());
                        arrayList = MembersDATA.getInstance(v.getContext()).membersDAO().getListObjMEM();
                        setDataMEM(arrayList);
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
                        dialog1.setContentView(R.layout.detail_thanhvien);
                        TextView tv_ma = dialog1.findViewById(R.id.tv_maTV);
                        TextView tv_ten = dialog1.findViewById(R.id.tv_tenTV);
                        TextView tv_nam = dialog1.findViewById(R.id.tv_namTV);
                        tv_ma.setText(members.getKhanhnqph27525CP17315maTV()+"");
                        tv_ten.setText(members.getKhanhnqph27525CP17315tenthanhvien());
                        tv_nam.setText(members.getKhanhnqph27525CP17315namsinh());

                        dialog1.show();
                    }
                });
                builder.setNegativeButton("sửa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog dialog2 = new Dialog(v.getContext(), androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert);
                        dialog2.setContentView(R.layout.dialog_members_update);
                        EditText edt_ma = dialog2.findViewById(R.id.edt_mathanhvien_up);
                        EditText edt_ten = dialog2.findViewById(R.id.edt_tenthanhvien_up);
                        EditText edt_nam = dialog2.findViewById(R.id.edt_namsinh_up);
                        Button btn_cancel = dialog2.findViewById(R.id.btn_cancel_thanhvien_up);
                        Button btn_add = dialog2.findViewById(R.id.btn_update_thanhvien);
                        edt_ma.setText(members.getKhanhnqph27525CP17315maTV()+"");
                        edt_ten.setText(members.getKhanhnqph27525CP17315tenthanhvien());
                        edt_nam.setText(members.getKhanhnqph27525CP17315namsinh());
                        btn_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                            }
                        });
                        btn_add.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (edt_ma.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống mã", Toast.LENGTH_SHORT).show();
                                }else if (edt_ten.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống họ tên", Toast.LENGTH_SHORT).show();
                                }else if (edt_nam.getText().toString().trim().isEmpty()){
                                    Toast.makeText(v.getContext(), "Không được để trống năm sinh", Toast.LENGTH_SHORT).show();
                                }else {
                                    membersnew = members;
                                    membersnew.setKhanhnqph27525CP17315maTV(Integer.parseInt(edt_ma.getText().toString().trim()));
                                    membersnew.setKhanhnqph27525CP17315tenthanhvien(edt_ten.getText().toString().trim());
                                    membersnew.setKhanhnqph27525CP17315namsinh(edt_nam.getText().toString().trim());
                                    MembersDATA.getInstance(v.getContext()).membersDAO().updateObjMEM(membersnew);
                                    arrayList = MembersDATA.getInstance(v.getContext()).membersDAO().getListObjMEM();
                                    setDataMEM(arrayList);
                                    dialog2.dismiss();
                                }
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

    public class ObjMembersViewHolder extends RecyclerView.ViewHolder{
        private TextView maThanhVien;
        private TextView hotenThanhVien;
        private TextView date;
        private ImageView img_delete;
        public ObjMembersViewHolder(@NonNull View itemView) {
            super(itemView);
            maThanhVien = itemView.findViewById(R.id.tv_mathanhvien);
            hotenThanhVien = itemView.findViewById(R.id.tv_hotenthanhvien);
            date = itemView.findViewById(R.id.namsinhthanhvien);
            img_delete = itemView.findViewById(R.id.img_delete);
        }
    }
}
