package com.gdiama.infrastructure.rest.impl;

import com.gdiama.infrastructure.rest.LiquidityEndpoint;
import com.gdiama.infrastructure.rest.resources.PoolResource;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.UUID;


@Controller
public class LiquidityEndpointImpl implements LiquidityEndpoint {

    public PoolResource createPool(UUID uuid, PoolResource poolResource) {
        return new PoolResource(uuid.toString(), poolResource.getSeeds() * Math.random());
    }

    public PoolResource getPool() {
        return new PoolResource("blah", 12.37);
    }

}
