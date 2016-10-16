package aa.mine.service.dubbo.filter;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.RpcResult;

public class DubboFilter implements Filter{

	/**
	 * dubbo提供了web filter类似的com.alibaba.dubbo.rpc.Filter
	 * 我们可以在dubbo提供的服务提供方和消费方都可以自定义过滤器，
	 * 从而可以获得方法调用的时间或参数、返回结果及异常信息.
	 */
	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		//获取远程服务的上下文信息
		RpcContext context = RpcContext.getContext();
		URL url = context.getUrl();
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		if (url != null) {			
			System.out.println("\n\ndubbo-one-service\t远程服务URL:"+url.toString());
			System.out.println("dubbo-one-service\t当前时间:"+formater.format(date));
			return invoker.invoke(invocation);
		} else {
			return new RpcResult();
		}		
	}

}
