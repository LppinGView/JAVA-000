package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter extends FullHttpRequest {
    
    void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
    
}
