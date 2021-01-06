<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="讲师id" prop="lecturerid">
      <el-input v-model="dataForm.lecturerid" placeholder="讲师id"></el-input>
    </el-form-item>
    <el-form-item label="商品标题" prop="producttitle">
      <el-input v-model="dataForm.producttitle" placeholder="商品标题"></el-input>
    </el-form-item>
    <el-form-item label="封面图" prop="coverimg">
      <el-input v-model="dataForm.coverimg" placeholder="封面图"></el-input>
    </el-form-item>
    <el-form-item label="状态，1=启用；2=禁用；0=删除；" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态，1=启用；2=禁用；0=删除；"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="productprice">
      <el-input v-model="dataForm.productprice" placeholder="价格"></el-input>
    </el-form-item>
    <el-form-item label="折扣" prop="productdiscount">
      <el-input v-model="dataForm.productdiscount" placeholder="折扣"></el-input>
    </el-form-item>
    <el-form-item label="" prop="modifiedtime">
      <el-input v-model="dataForm.modifiedtime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createtime">
      <el-input v-model="dataForm.createtime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="讲义" prop="producthandout">
      <el-input v-model="dataForm.producthandout" placeholder="讲义"></el-input>
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
          lecturerid: '',
          producttitle: '',
          coverimg: '',
          status: '',
          remark: '',
          productprice: '',
          productdiscount: '',
          modifiedtime: '',
          createtime: '',
          producthandout: ''
        },
        dataRule: {
          lecturerid: [
            { required: true, message: '讲师id不能为空', trigger: 'blur' }
          ],
          producttitle: [
            { required: true, message: '商品标题不能为空', trigger: 'blur' }
          ],
          coverimg: [
            { required: true, message: '封面图不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态，1=启用；2=禁用；0=删除；不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          productprice: [
            { required: true, message: '价格不能为空', trigger: 'blur' }
          ],
          productdiscount: [
            { required: true, message: '折扣不能为空', trigger: 'blur' }
          ],
          modifiedtime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createtime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          producthandout: [
            { required: true, message: '讲义不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/passcodeproduct/basis/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.lecturerid = data.basis.lecturerid
                this.dataForm.producttitle = data.basis.producttitle
                this.dataForm.coverimg = data.basis.coverimg
                this.dataForm.status = data.basis.status
                this.dataForm.remark = data.basis.remark
                this.dataForm.productprice = data.basis.productprice
                this.dataForm.productdiscount = data.basis.productdiscount
                this.dataForm.modifiedtime = data.basis.modifiedtime
                this.dataForm.createtime = data.basis.createtime
                this.dataForm.producthandout = data.basis.producthandout
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
              url: this.$http.adornUrl(`/passcodeproduct/basis/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'lecturerid': this.dataForm.lecturerid,
                'producttitle': this.dataForm.producttitle,
                'coverimg': this.dataForm.coverimg,
                'status': this.dataForm.status,
                'remark': this.dataForm.remark,
                'productprice': this.dataForm.productprice,
                'productdiscount': this.dataForm.productdiscount,
                'modifiedtime': this.dataForm.modifiedtime,
                'createtime': this.dataForm.createtime,
                'producthandout': this.dataForm.producthandout
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
