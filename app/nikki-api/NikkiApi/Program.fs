open System
open Microsoft.AspNetCore.Builder
open Microsoft.Extensions.Hosting
open System.Threading.Tasks
open Microsoft.AspNetCore.Http

[<EntryPoint>]
let main args =
    let builder = WebApplication.CreateBuilder(args)
    let app = builder.Build()
    
    app.MapGet("/v1/systems/ping", Func<string>(fun () -> "pong")) |> ignore

    app.MapPost("/nikki", Func<string, Task<IResult>>(fun request ->
        task {
            return Results.Ok("Hello World!")
        }
    )) |> ignore
    
    app.Run()
    0 // Exit code
