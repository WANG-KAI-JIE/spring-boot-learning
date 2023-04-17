const app = Vue.createApp({
    data() {
        return {
            message: 'hello websocket',
            id: 1,
            content: '',
            ws: null
        }
    },
    methods: {
        open(){
            console.log("open")
            this.ws = new WebSocket(`ws://localhost:8080/socket/${this.id}`)
            this.ws.onopen = () =>{
                console.log("websocket 连接成功")
            }
            this.ws.onclose = () =>{
                console.log("websocket 已经关闭")
            }
            this.ws.onerror = () =>{
                console.log("websocket 出现异常")
            }
            this.ws.onmessage = (res) =>{
                console.log(res)
                this.message = this.message.concat(res.data)
            }
        },
        send(msg){
            console.log("send")
            this.ws.send(this.content)
            this.content = ""
        },
        logout(){
            this.ws.onclose = () =>{
                console.log("websocket 连接关闭")
            }
        }
    }
})