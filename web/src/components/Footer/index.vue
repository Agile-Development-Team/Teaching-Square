<template>
  <div class="footer">
    <div class="footer-container">
      <div class="footerList">
        <div class="footerItem">
          <h4>操作指南</h4>
          <ul class="footerItemCon">
            <li>登陆指南</li>
            <li>注册指南</li>
            <li>使用指南</li>
          </ul>
        </div>
        <div class="footerItem">
          <h4>教学方式</h4>
          <ul class="footerItemCon">
            <li>教师通道</li>
            <li>学生通道</li>
            <li>更多信息</li>
          </ul>
        </div>
        <div class="footerItem">
          <h4>教学评估</h4>
          <ul class="footerItemCon">
            <li>教师通道</li>
            <li>学生通道</li>
            <li>更多信息</li>
          </ul>
        </div>
        <div class="footerItem">
          <h4>更多服务</h4>
          <ul class="footerItemCon">
            <li>教师通道</li>
            <li>学生通道</li>
            <li>更多信息</li>
          </ul>
        </div>
        <div class="footerItem">
          <h4>教学平方</h4>
          <ul class="footerItemCon">
            <li>教师通道</li>
            <li>学生通道</li>
            <li>更多信息</li>
          </ul>
        </div>
        <div class="footerItem">
          <h4>帮助中心</h4>
          <img src="./images/2dma.png" />
        </div>
      </div>
      <div class="copyright">
        <ul class="helpLink">
          <li>
            客户留言
            <span class="space"></span>
          </li>
          <li>
            微信公众号
            <span class="space"></span>
          </li>
          <li>
            服务条款
            <span class="space"></span>
          </li>
          <li>
            版本说明
            <span class="space"></span>
          </li>
          <li>
            联系我们
            <span class="space"></span>
          </li>
          <li>
            帮助中心
            <span class="space"></span>
          </li>
          <li>
            开发团队
            <span class="space"></span>
          </li>
          <li>
            友情链接
            <span class="space"></span>
          </li>
          <li>关于我们</li>
        </ul>
        <p>联系方式</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "",
};
</script>

<style scoped lang="less">
.footer {
  background-color: rgb(222, 236, 253);

  .footer-container {
    width: 1200px;
    margin: 0 auto;
    padding: 0 15px;

    .footerList {
      padding: 20px;
      border-bottom: 1px solid #e4e1e1;
      border-top: 1px solid #e4e1e1;
      overflow: hidden;
      padding-left: 40px;

      .footerItem {
        width: 16.6666667%;
        float: left;

        h4 {
          font-size: 14px;
        }

        .footerItemCon {
          li {
            line-height: 18px;
          }
        }

        &:last-child img {
          width: 121px;
        }
      }
    }

    .copyright {
      padding-bottom: 20px;

      .helpLink {
        text-align: center;

        li {
          display: inline;

          .space {
            border-left: 1px solid rgb(0, 110, 253);
            width: 1px;
            height: 13px;
            background: rgb(0, 110, 253);
            margin: 8px 10px;
          }
        }
      }

      p {
        margin: 10px 0;
        text-align: center;
      }
    }
  }
}
</style>