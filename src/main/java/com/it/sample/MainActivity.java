package com.it.sample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.it.core.activity.ActivityBase;
import com.it.core.menu.SideMenuItem;

import java.util.ArrayList;

public class MainActivity extends ActivityBase {

	private static final int FIRST_MENU_ITEM = 101;
	private static final int SECOND_MENU_ITEM = 102;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		// Инициализация меню
		ArrayList<SideMenuItem> menuItems = new ArrayList<SideMenuItem>();
		menuItems.add(new SideMenuItem(FIRST_MENU_ITEM, getString(R.string.first_item), R.drawable.ic_action_accept_white, false));
		menuItems.add(new SideMenuItem(SECOND_MENU_ITEM, getString(R.string.second_item), R.drawable.ic_action_accept_white, false));
		setNavigationDrawer(R.layout.activity_main, R.id.container, R.id.drawer_layout, R.id.navigation_drawer,
				R.menu.main, R.menu.global,
				R.string.app_name,
				menuItems, 0, true, true);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onAfterCreate() {
		super.onAfterCreate();
	}

	@Override
	protected boolean needsAuthentication() {
		return true;
	}

	@Override
	public void onNavigationDrawerItemSelected(SideMenuItem item) {
		// update the main content by replacing fragments
		Fragment checkedFragment;
		switch (item.Id) {
			case FIRST_MENU_ITEM:
				checkedFragment = SimpleFragment.newInstance(item.Title);
				break;
			case SECOND_MENU_ITEM:
				checkedFragment = SimpleFragment.newInstance(item.Title);
				break;
			default:
				checkedFragment = new SimpleFragment();
				break;
		}
		setFragmentActive(checkedFragment);
		super.onNavigationDrawerItemSelected(item);
	}

	/**
	 * Установить фрагмент активным
	 *
	 * @param fragment Фрагмент
	 */
	private void setFragmentActive(Fragment fragment) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.container, fragment)
				.commitAllowingStateLoss();
	}

}
