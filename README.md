# basicFramework
<p class="p2"><span class="s1">基础：强代理架构</span></p>
<p class="p2"><span class="s1">适用环境：多人开发</span></p>
![image](https://github.com/DarksKnight/basicFramework/blob/master/basicuml.png)
<p class="p2"><span class="s1">简介：</span></p>
<p class="p2"><span class="s1">自己想出的一种设计模式，不是很难，大多数应该自己也想到并且开发过，但是我没有在其他地方看到过有类似的架构，所以我将其命名为强代理架构。</span></p>
<p class="p2"><span class="s1">这个架构，主要是多角色开发，这仅仅为基础型架构，可以在这基础上添加更多东西，使其更加丰富。</span></p>
<p class="p2"><span class="s1">架构的核心思想：</span></p>
<p class="p2"><span class="s1">每一个请求作为一个对象操作，使其独立，并且适用于多人开发，减少团队开发时的冲突</span></p>
<p class="p2"><span class="s1">架构有三种角色：</span></p>
<p class="p4"><span class="s1">1.model</span></p>
<p class="p2"><span class="s1">用于请求数据并且获取数据将其封装成对象（该项目中采用了</span><span class="s4">Gson</span><span class="s1">将</span><span class="s4">Json</span><span class="s1">自动封装成对象）</span></p>
<p class="p4"><span class="s1">2.rule</span></p>
<p class="p2"><span class="s1">用于过滤（处理数据源），将获取到的对象放入其中进行数据的修改，再将修改好的数据给</span><span class="s4">View</span><span class="s1">层</span></p>
<p class="p4"><span class="s1">3.view</span></p>
<p class="p2"><span class="s1">获取数据，无需修改，直接使用，因为</span><span class="s4">rule</span><span class="s1">层已经对数据进行了必要的修改</span></p>
<p class="p5"><span class="s1"></span><br /></p>
<p class="p2"><span class="s1">这个架构的好处：</span></p>
<p class="p2"><span class="s4">1.</span><span class="s1">解决了文件过多的问题，因为不是每个请求都需要进行修改</span></p>
<p class="p2"><span class="s4">2.</span><span class="s1">很好的进行了分层并且独立开来，互不冲突，降低了耦合性</span></p>
<p class="p2"><span class="s4">3.</span><span class="s1">尽可能的降低了内存消耗，由于单例模式，所以对象相对不会很多</span></p>
<p class="p2"><span class="s4">4.</span><span class="s1">扩展性强</span></p>