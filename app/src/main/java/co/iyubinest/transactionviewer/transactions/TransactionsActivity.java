/**
 * Copyright (C) 2017 Cristian Gomez Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.iyubinest.transactionviewer.transactions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.iyubinest.transactionviewer.BaseActivity;
import co.iyubinest.transactionviewer.R;
import co.iyubinest.transactionviewer.products.Product;

public class TransactionsActivity extends BaseActivity {

  private static final String PRODUCT_KEY = "PRODUCT_KEY";

  public static Intent create(BaseActivity activity, Product product) {
    Intent intent = new Intent(activity, TransactionsActivity.class);
    Bundle bundle = new Bundle();
    bundle.putParcelable(PRODUCT_KEY, product);
    intent.putExtras(bundle);
    return intent;
  }

  @BindView(R.id.transactions_list)
  TransactionsWidget transactionsView;
  @BindView(R.id.transactions_total)
  TextView totalView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.transactions_activity);
    ButterKnife.bind(this);
    totalView.setText(product().grandTotal());
    transactionsView.add(product().transactions());
  }

  private Product product() {
    return getIntent().getParcelableExtra(PRODUCT_KEY);
  }
}
