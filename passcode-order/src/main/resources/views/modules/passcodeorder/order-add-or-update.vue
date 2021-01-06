<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商品id" prop="productid">
      <el-input v-model="dataForm.productid" placeholder="商品id"></el-input>
    </el-form-item>
    <el-form-item label="会员id" prop="membersid">
      <el-input v-model="dataForm.membersid" placeholder="会员id"></el-input>
    </el-form-item>
    <el-form-item label="状态，0=删除；1=待支付；2=已支付；" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态，0=删除；1=待支付；2=已支付；"></el-input>
    </el-form-item>
    <el-form-item label="付款价格" prop="paymentprice">
      <el-input v-model="dataForm.paymentprice" placeholder="付款价格"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="" prop="modifiedtime">
      <el-input v-model="dataForm.modifiedtime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createtime">
      <el-input v-model="dataForm.createtime" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          productid: '',
          membersid: '',
          status: '',
          paymentprice: '',
          remark: '',
          modifiedtime: '',
          createtime: ''
        },
        dataRule: {
          productid: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          membersid: [
            { required: true, message: '会员id不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态，0=删除；1=待支付；2=已支付；不能为空', trigger: 'blur' }
          ],
          paymentprice: [
            { required: true, message: '付款价格不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          modifiedtime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createtime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/passcodeorder/order/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productid = data.order.productid
                this.dataForm.membersid = data.order.membersid
                this.dataForm.status = data.order.status
                this.dataForm.paymentprice = data.order.paymentprice
                this.dataForm.remark = data.order.remark
                this.dataForm.modifiedtime = data.order.modifiedtime
                this.dataForm.createtime = data.order.createtime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/passcodeorder/order/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productid': this.dataForm.productid,
                'membersid': this.dataForm.membersid,
                'status': this.dataForm.status,
                'paymentprice': this.dataForm.paymentprice,
                'remark': this.dataForm.remark,
                'modifiedtime': this.dataForm.modifiedtime,
                'createtime': this.dataForm.createtime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
