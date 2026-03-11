/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.systems.modules.misc;

import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.proxies.Proxies;
import meteordevelopment.meteorclient.systems.proxies.Proxy;

public class ProxiesModule extends Module {
    public ProxiesModule() {
        super(Categories.Misc, "proxies", "Manages proxy connections for server routing. Configure proxies in the Proxies screen on the multiplayer tab.");
    }

    @Override
    public String getInfoString() {
        Proxy proxy = Proxies.get().getEnabled();
        if (proxy == null) return "None";
        String name = proxy.name.get();
        if (name != null && !name.isEmpty()) return name;
        return proxy.address.get() + ":" + proxy.port.get();
    }
}
