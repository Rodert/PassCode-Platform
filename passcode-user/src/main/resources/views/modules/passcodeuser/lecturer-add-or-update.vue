<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="name">
      <el-input v-model="dataForm.name" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="" prop="password">
      <el-input v-model="dataForm.password" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sex">
      <el-input v-model="dataForm.sex" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="age">
      <el-input v-model="dataForm.age" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="email">
      <el-input v-model="dataForm.email" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="adminhead">
      <el-input v-model="dataForm.adminhead" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="手机号" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号"></el-input>
    </el-form-item>
    <el-form-item label="状态，1=启用；2=禁用；0=删除；" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态，1=启用；2=禁用；0=删除；"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="" prop="lastlogintime">
      <el-input v-model="dataForm.lastlogintime" placeholder=""></el-input>
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
          name: '',
          password: '',
          sex: '',
          age: '',
          email: '',
          adminhead: '',
          mobile: '',
          status: '',
          remark: '',
          lastlogintime: '',
          modifiedtime: '',
          createtime: ''
        },
        dataRule: {
          name: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          adminhead: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态，1=启用；2=禁用；0=删除；不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          lastlogintime: [
            { required: true, message: '不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/passcodeuser/lecturer/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.lecturer.name
                this.dataForm.password = data.lecturer.password
                this.dataForm.sex = data.lecturer.sex
                this.dataForm.age = data.lecturer.age
                this.dataForm.email = data.lecturer.email
                this.dataForm.adminhead = data.lecturer.adminhead
                this.dataForm.mobile = data.lecturer.mobile
                this.dataForm.status = data.lecturer.status
                this.dataForm.remark = data.lecturer.remark
                this.dataForm.lastlogintime = data.lecturer.lastlogintime
                this.dataForm.modifiedtime = data.lecturer.modifiedtime
                this.dataForm.createtime = data.lecturer.createtime
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
              url: this.$http.adornUrl(`/passcodeuser/lecturer/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'password': this.dataForm.password,
                'sex': this.dataForm.sex,
                'age': this.dataForm.age,
                'email': this.dataForm.email,
                'adminhead': this.dataForm.adminhead,
                'mobile': this.dataForm.mobile,
                'status': this.dataForm.status,
                'remark': this.dataForm.remark,
                'lastlogintime': this.dataForm.lastlogintime,
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
