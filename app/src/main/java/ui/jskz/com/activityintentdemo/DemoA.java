package ui.jskz.com.activityintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

public class DemoA extends Activity implements View.OnClickListener {
    private Button mABtn;
    private Button mBBtn;
    private Button mCBtn;

    private String firstname;
    private String secondname;

    private ArrayList<String> listA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_a);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        listA = new ArrayList<>();
        listA.add("北京");
        listA.add("上海");
        listA.add("南京");
    }

    private void initView() {
        this.mABtn = (Button) findViewById(R.id.mi_one1_btn);
        this.mBBtn = (Button) findViewById(R.id.mi_one2_btn);
        this.mCBtn = (Button) findViewById(R.id.mi_one3_btn);
    }

    private void initListener() {
        mABtn.setOnClickListener(this);
        mBBtn.setOnClickListener(this);
        mCBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mi_one1_btn:
                Intent i1 = new Intent(DemoA.this, DemoB.class);
                i1.putExtra("name", mABtn.getText().toString());
                i1.putStringArrayListExtra("List", listA);
                startActivityForResult(i1, 1);
                break;
            case R.id.mi_one2_btn:
                mBBtn.setText(firstname);
                break;
            case R.id.mi_one3_btn:
                mCBtn.setText(secondname);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        firstname = data.getExtras().getString("firstname");
        secondname = data.getExtras().getString("secondname");
        Toast.makeText(getApplicationContext(), "恭喜小帅哥回到DemoA！", Toast.LENGTH_SHORT).show();
    }
}
