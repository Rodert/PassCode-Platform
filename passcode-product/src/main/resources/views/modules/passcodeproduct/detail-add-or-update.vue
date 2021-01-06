<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商品id" prop="productid">
      <el-input v-model="dataForm.productid" placeholder="商品id"></el-input>
    </el-form-item>
    <el-form-item label="视频封面图" prop="videocoverimg">
      <el-input v-model="dataForm.videocoverimg" placeholder="视频封面图"></el-input>
    </el-form-item>
    <el-form-item label="工具" prop="tool">
      <el-input v-model="dataForm.tool" placeholder="工具"></el-input>
    </el-form-item>
    <el-form-item label="源码" prop="code">
      <el-input v-model="dataForm.code" placeholder="源码"></el-input>
    </el-form-item>
    <el-form-item label="视频" prop="video">
      <el-input v-model="dataForm.video" placeholder="视频"></el-input>
    </el-form-item>
    <el-form-item label="状态，1=启用；2=禁用；0=删除；" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态，1=启用；2=禁用；0=删除；"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="sort">
      <el-input v-model="dataForm.sort" placeholder="排序"></el-input>
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
          videocoverimg: '',
          tool: '',
          code: '',
          video: '',
          status: '',
          sort: '',
          remark: '',
          modifiedtime: '',
          createtime: ''
        },
        dataRule: {
          productid: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          videocoverimg: [
            { required: true, message: '视频封面图不能为空', trigger: 'blur' }
          ],
          tool: [
            { required: true, message: '工具不能为空', trigger: 'blur' }
          ],
          code: [
            { required: true, message: '源码不能为空', trigger: 'blur' }
          ],
          video: [
            { required: true, message: '视频不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态，1=启用；2=禁用；0=删除；不能为空', trigger: 'blur' }
          ],
          sort: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/passcodeproduct/detail/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.productid = data.detail.productid
                this.dataForm.videocoverimg = data.detail.videocoverimg
                this.dataForm.tool = data.detail.tool
                this.dataForm.code = data.detail.code
                this.dataForm.video = data.detail.video
                this.dataForm.status = data.detail.status
                this.dataForm.sort = data.detail.sort
                this.dataForm.remark = data.detail.remark
                this.dataForm.modifiedtime = data.detail.modifiedtime
                this.dataForm.createtime = data.detail.createtime
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
              url: this.$http.adornUrl(`/passcodeproduct/detail/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'productid': this.dataForm.productid,
                'videocoverimg': this.dataForm.videocoverimg,
                'tool': this.dataForm.tool,
                'code': this.dataForm.code,
                'video': this.dataForm.video,
                'status': this.dataForm.status,
                'sort': this.dataForm.sort,
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
