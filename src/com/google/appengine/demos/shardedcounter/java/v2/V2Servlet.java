/* Copyright (c) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.appengine.demos.shardedcounter.java.v2;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet for incrementing a configurable sharded counter.
 */
@SuppressWarnings("serial")
public class V2Servlet extends HttpServlet {
    @Override
    public final void doGet(final HttpServletRequest req,
            final HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");

        String counterName = req.getParameter("name");
        String action = req.getParameter("action");
        String shards = req.getParameter("shards");

        ShardedCounter counter = new ShardedCounter(counterName);

        if ("increment".equals(action)) {
            counter.increment();
            resp.getWriter().println("Counter incremented.");
        } else if ("increase_shards".equals(action)) {
            int inc = Integer.valueOf(shards);
            counter.addShards(inc);
            resp.getWriter().println("Shard count increased by " + inc + ".");
        } else {
            resp.getWriter().println("getCount() -> " + counter.getCount());
        }
    }
}
