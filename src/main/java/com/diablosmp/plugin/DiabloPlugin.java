package com.diablosmp.plugin;

import com.diablosmp.plugin.managers.AbilityManager;
import com.diablosmp.plugin.managers.CooldownManager;
import com.diablosmp.plugin.managers.TrustManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DiabloPlugin extends JavaPlugin {

    private static DiabloPlugin instance;
    private AbilityManager abilityManager;
    private TrustManager trustManager;
    private CooldownManager cooldownManager;

    @Override
    public void onEnable() {
        instance = this;

        // Initialize Managers
        this.cooldownManager = new CooldownManager();
        this.trustManager = new TrustManager();
        this.abilityManager = new AbilityManager(this);

        getLogger().info("DiabloSMP Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DiabloSMP Plugin has been disabled!");
    }

    public static DiabloPlugin getInstance() {
        return instance;
    }

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }

    public TrustManager getTrustManager() {
        return trustManager;
    }

    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }
}
