package com.diablosmp.plugin.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {
    private final Map<UUID, Long> cooldowns = new HashMap<>();

    public void setCooldown(UUID uuid, int seconds) {
        cooldowns.put(uuid, System.currentTimeMillis() + (seconds * 1000L));
    }

    public boolean isOnCooldown(UUID uuid) {
        return cooldowns.containsKey(uuid) && cooldowns.get(uuid) > System.currentTimeMillis();
    }

    public long getRemaining(UUID uuid) {
        return Math.max(0, (cooldowns.getOrDefault(uuid, 0L) - System.currentTimeMillis()) / 1000);
    }
}
