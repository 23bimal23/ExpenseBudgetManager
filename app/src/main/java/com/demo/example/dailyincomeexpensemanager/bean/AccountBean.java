package com.demo.example.dailyincomeexpensemanager.bean;

import com.demo.example.dailyincomeexpensemanager.MyUtils;
import java.util.List;


public class AccountBean {
    private List<CategoryBean> categories;
    private List<CategoryBean> expenseCategory;
    private List<CategoryBean> incomeCategory;
    private List<TemplateBean> templates;


    private String f91id = "";
    private String name = "";
    private String email = "";
    private int currency = 0;

    public int getCurrency() {
        return this.currency;
    }

    public void setCurrency(int i) {
        this.currency = i;
    }

    public String getCurrencyName() {
        return MyUtils.currencyList[this.currency][1];
    }

    public String getCurrencySymbol() {
        return MyUtils.currencyList[this.currency][0];
    }

    public String getId() {
        return this.f91id;
    }

    public void setId(String str) {
        this.f91id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String toString() {
        return this.name;
    }

    public List<CategoryBean> getCategories() {
        return this.categories;
    }

    public void setCategories(List<CategoryBean> list) {
        this.categories = list;
    }

    public List<TemplateBean> getTemplates() {
        return this.templates;
    }

    public void setTemplates(List<TemplateBean> list) {
        this.templates = list;
    }

    public List<CategoryBean> getIncomeCategory() {
        return this.incomeCategory;
    }

    public void setIncomeCategory(List<CategoryBean> list) {
        this.incomeCategory = list;
    }

    public List<CategoryBean> getExpenseCategory() {
        return this.expenseCategory;
    }

    public void setExpenseCategory(List<CategoryBean> list) {
        this.expenseCategory = list;
    }
}
