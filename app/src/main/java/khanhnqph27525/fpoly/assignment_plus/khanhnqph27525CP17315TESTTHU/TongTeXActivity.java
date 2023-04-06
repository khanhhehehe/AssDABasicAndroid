package khanhnqph27525.fpoly.assignment_plus.khanhnqph27525CP17315TESTTHU;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import khanhnqph27525.fpoly.assignment_plus.R;

public class TongTeXActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<TongTexDTO> tongTexDTOList = new ArrayList<>();
    private TongTeXAdapter tongTeXAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong_te_xactivity);
        recyclerView = findViewById(R.id.recycler_tongSPLoai);
        tongTeXAdapter = new TongTeXAdapter(getBaseContext());
        tongTexDTOList = T_EX_DATA.getInstance(getBaseContext()).tExDao().loadAllSP();
        tongTeXAdapter.setDataTong(tongTexDTOList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(tongTeXAdapter);

    }
}