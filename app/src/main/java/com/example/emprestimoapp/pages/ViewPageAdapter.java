package com.example.emprestimoapp.pages;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.emprestimoapp.pages.EmprestimosPage;
import com.example.emprestimoapp.pages.EquipamentosPage;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1)
            return new EquipamentosPage();
        else
            return new EmprestimosPage();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
